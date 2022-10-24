package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer implements Participant {
	// [1]딜러는 패를 받고, [2]패를 섞고, [3]패를 나눠준다. [4]모든 과정과 게임이 끝나면 카드를 오픈한다.
	// (2022-10-22) 딜러에게 히트하는 개념은 없다. 16이하면 그냥 카드를 받을뿐.
	public List<Card> cards;
	public List<Card> cardDeck = new ArrayList<>();
	private static final int DEALER_HIT_POINT = 16;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// 딜러가 받은 카드들을 저장할 공간을 만들어준다, 딜러객체가 생성될때 가지고있으면 더 효과적이지 않을까..?
	public Dealer() {
		cardDeck = new ArrayList<>();
	}

	// [1] 카드를 받는다
	@Override
	public void receiveCard(Card card) {
		this.cardDeck.add(card);
	}

	// [2] 패를 섞는다
	public void shuffle() {
		Collections.shuffle(cards);
	}

	// [3] 패를 한장씩 나눠준다.
	public Card giveOneCard() {
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}

	// 2022-10-22 추가. 3번 4번 메소드와 관련된 내용이다. 딜러가 받은 카드를 cards가 아니라 cardDeck에 저장해 놨는데
	// 테스트코드 출력 시 딜러의 카드를 자꾸 cards에서 불러와가지고 remove(0)이 짤려서 출력이 되었다.
	// 그로인해 위 3번 메소드에 이상이 있는줄 알고 몇시간이나 헤맸는데 아니였다. 아래 4번메소드의 출력을 cardDeck가 아니라
	// cards에서 자꾸 출력했기 때문이다. ㅠㅠ 그래도 고쳐져서 너무나 뿌듯하다.

	// [4] 카드를 오픈한다.
	@Override
	public void openCard() {
		System.out.print("\n딜러의 카드는 : ");
		for (Card card : cardDeck) {
			System.out.print(card.toString() + " ");
		}

	}

	public void hit() {
		if (this.printSumPoint() <= DEALER_HIT_POINT) {
			Card card = new Card();
			card = cards.remove(0);
			this.receiveCard(card);
		}
	}

	// 딜러의 카드 합이 16 이하이며 플레이어가 stay시 딜러는 카드를 추가로 받아야한다. 딜러 전용 메소드 생성.
	public void coercionHit() {
		while (this.printSumPoint() <= DEALER_HIT_POINT) {
			Card card = new Card();
			card = cards.remove(0);
			this.receiveCard(card);
		}
	}
	
	// 딛러 버스트 구현
	@Override
	public void bust(Player player, Dealer dealer) {
		if (dealer.printSumPoint() > BLACK_JACK_NUM){
			System.out.println("\n딜러가 산산조각 나버렸구만! 자네의 승리라네!");
			System.out.println("금액 획득! : " + player.playerMoney());
			player.playerMoney += player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}
		
	}

	// 딜러의 카드의 총 합.
	@Override
	public int sumPoint() {
		int sum = 0;
		for (Card card : cardDeck) {
			sum += card.getCoercionCardNum();
			if (card.getCoercionCardNum()%10 == 1) {
				if ((sum+10)<=21) {
					sum+=10;
				}
			}
			
		}
		
		System.out.print("\n딜러 카드의 총 합은? : " + sum + "\n");
		return sum;
	}


	// 카드 합계 출력 메소드.
	public int printSumPoint() {
		int sum = 0;
		for (Card card : cardDeck) {
			sum += card.getCoercionCardNum();
			if (card.getCoercionCardNum()%10 == 1) {
				if ((sum+10)<=21) {
					sum+=10;
				}
			}
		}
		return sum;
	}

}
