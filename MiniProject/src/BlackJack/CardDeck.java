package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	public List<Card> cards;
	private static final String[] PATTERN = { "SPADE", "DIAMOND", "HEART", "CLOVER" };
	private static final int CARD_NUM = 13;
	private String pattern;
	private String cardNum;
	private int point;

	// 새로운 생성자를 만들어 카드의 번호가 10 이상일때 10으로 고정되게 해야한다.
	public CardDeck(String pattern, String cardNum, int point) {
		this.pattern = pattern;
		this.cardNum = cardNum;
		this.point = this.cardPoint(point);
	}

	public CardDeck() {
		cards = new ArrayList<>();
		// LinkedList로 인덱스 관리의 효율성을 높이는것도 좋지만 나는 블랙잭의 현실적인 규칙
		// -> 패를 섞고 패는 맨 위에 있는것부터 배분 이라는 규칙에 철저히 의거해 자동으로 인덱스를 앞당겨주는 ArrayList를
		// 사용하려고 한다.

		for (String pattern : PATTERN) {
			for (int cardNum = 1; cardNum <= CARD_NUM; cardNum++) {
				Card card = new Card();
				String num;
				if (cardNum == 1) {
					num = "A";
				} else if (cardNum == 11) {
					num = "J";
				} else if (cardNum == 12) {
					num = "Q";
				} else if (cardNum == 13) {
					num = "K";
				} else {
					num = String.valueOf(cardNum);
				}
				card.setCardNum(num);
				card.setCardKind(pattern);
				cards.add(card);

			}
		}
	}

	public int cardPoint(int number) {
		if (number >= 11) {
			number = 10;
		}
		return number;
	}

	@Override
	public String toString() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
		return "";
	}

}
