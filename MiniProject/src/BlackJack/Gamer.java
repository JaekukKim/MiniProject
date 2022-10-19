package BlackJack;

import java.util.List;

public class Gamer {
	private List<Card> cards;

	public Card receiveCard() {
		Card card = cards.get(0);
		card = cards.remove(0);
		return card;
	}

	public List<Card> openCard() {
		return null;
	}

}
