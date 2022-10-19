package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer{
	private List<Card> cards = new ArrayList<>();
	private List<Card> cardList;
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	// 플레이어와 마찬가지로 딜러도 카드를 받아야한다.
	public Card receiveCard() {
		Card card = cards.get(0);
		card = cards.remove(0);
		return card;
	}
	
	@Override
	public String toString() {
		for (Card card : cards) {
			System.out.print(card.toString());
			
		}
		return "딜러의 카드 [=" + cards + ", cardList=" + cardList + "]";
	}

	public List<Card> openCard() {
		return null;
	}
	
	// 패를 섞는 행위는 딜러가 한다.
	public void shuffle() {
		Collections.shuffle(cardList);
	}
}
