package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class Player {
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

	// [2] 카드를 받는다
	public void receiveCard(Card card) {
		this.cards.add(card);
	}

	// [4]
	public void openCard() {
		System.out.print("플레이어의 카드는 : ");
		for (Card card : cards) {
			System.out.print(card.toString() + " ");
		}

	}


	// 플레이어 카드의 총 합.
	public int sumPoint() {
		int sum = 0;

		for (Card card : cards) {
			sum += card.getCoercionCardNum();
		}
		System.out.println("\n플레이어의 점수는? : " + sum);
		return sum;
	}

}
