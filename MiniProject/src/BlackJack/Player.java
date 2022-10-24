package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Participant {
	// [1]플레이어는 돈을 걸고, [2]카드를 받고, [3]hit 여부를 결정하고 [4]카드를 오픈한다.
	// 플레이어는 카드를 계속 받을 수 있다.
	public List<Card> cards;
	public int playerMoney;

	public Player() {
		cards = new ArrayList<>();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// [1]
	public int betMoney(Scanner sc) {
		System.out.println("\n얼마를 걸텐가? 최소 배팅액은 $10000라네.");
		this.playerMoney();
		this.playerMoney = sc.nextInt();
		return this.playerMoney();
	}

	// [1-1]
	public int playerMoney() {
		return playerMoney;
	}

	// [2] 인터페이스에서 메소드 오버라이딩을 통한 카드 수령 메소드 구현.
	@Override
	public void receiveCard(Card card) {
		this.cards.add(card);
	}

	// [3]
	public void hit(Dealer dealer) {
		Card card = new Card();
		card = dealer.cards.remove(0);
		this.receiveCard(card);

	}

	// [4]
	@Override
	public void openCard() {
		System.out.print("\n플레이어의 카드는 : ");
		for (Card card : cards) {
			System.out.print(card.toString() + " ");
		}

	}

	// 플레이어 버스트 구현
	@Override
	public void bust(Player player, Dealer dealer) {
		if (player.printSumPoint() > BLACK_JACK_NUM) {
			System.out.println("\n자네가 산산조각 나버렸구만! 딜러의 승리라네!");
			System.out.println("금액 차감 : " + player.playerMoney());
			player.playerMoney -= player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}
	}

	// 플레이어 카드의 총 합. 인터페이스에서의 메소드 오버라이딩.
	@Override
	public int sumPoint() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getCoercionCardNum();
			if (card.getCoercionCardNum() % 10 == 1) {
				if ((sum + 10) <= 21) {
					sum += 10;
				}
			}
		}

		System.out.print("\n플레이어 카드의 총 합은? : " + sum + "\n");
		return sum;
	}

	// 카드 합계 출력 메소드.
	public int printSumPoint() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getCoercionCardNum();
			if (card.getCoercionCardNum() % 10 == 1) {
				if ((sum + 10) <= 21) {
					sum += 10;
				}
			}
		}

		return sum;
	}

}
