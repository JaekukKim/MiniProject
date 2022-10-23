package BlackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Participant {
	// [1]플레이어는 돈을 걸고, [2]카드를 받고, [3]hit 여부를 결정하고 [4]카드를 오픈한다.
	// 플레이어는 카드를 계속 받을 수 있다.
	public List<Card> cards;

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
		System.out.println("얼마를 걸텐가?");
		int playerMoney = sc.nextInt();
		System.out.println("게임을 시작하도록 하지.");
		return playerMoney;
	}

	// [2] 인터페이스에서 메소드 오버라이딩을 통한 카드 수령 메소드 구현.
	@Override
	public void receiveCard(Card card) {
		this.cards.add(card);
	}

	// [4]
	@Override
	public void openCard() {
		System.out.print("플레이어의 카드는 : ");
		for (Card card : cards) {
			System.out.print(card.toString() + " ");
		}

	}

	// 플레이어 카드의 총 합. 인터페이스에서의 메소드 오버라이딩.
	@Override
	public int sumPoint() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getCoercionCardNum();
		}

		System.out.print("\n플레이어 카드의 총 합은? : " + sum);
		return sum;
	}

	// 카드 합계 출력 메소드.
	public int printSumPoint() {
		int sum = 0;
		for (Card card : cards) {
			sum += card.getCoercionCardNum();
		}

		return sum;
	}

}
