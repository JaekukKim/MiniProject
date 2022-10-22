package BlackJack;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	// 카드 덱은 총 52장이며 카드의 종류는 4종류, 1종류마다 13장이다. j q k 는 10이 넘어가나 10으로 값을 고정한다.
	// 카드덱에선 카드에다가 무늬와 숫자를 매긴다. 즉 카드를 생성해야한다. 카드의 무늬와 숫자는 불변값이다.
	// 카드를 생성만해선 안된다 카드를 보관할 변수가 필요하다.

	public List<Card> cards;
	private static final String[] CARD_PATTERN = { "SPADE", "DIAMOND", "CLOVER", "HEART" };
	private static final int CARD_NUM = 13;
	// 카드 패턴과 카드 번호는 고유하며, 다른데서 건드릴 일 자체가 없다.

	// 카드는 한번 생성되고 변하지 않는다. 그럼 카드덱의 생성자에서 객체 생성과 동시에 초기화를 해 줄 수 있다.
	public CardDeck() {
		cards = new ArrayList<>();
		// 카드들을 저장할 배열을 하나 만들어주었다. 그리고 카드를 생성한다.

		for (String pattern : CARD_PATTERN) {
			for (int i = 1; i <= CARD_NUM; i++) {
				String specialCard;
				int coercionCardNum = i;

				switch (i) {
				case 1:
					specialCard = "A";
					break;
				case 11:
					specialCard = "J";
					break;
				case 12:
					specialCard = "Q";
					break;
				case 13:
					specialCard = "K";
					break;
				default:
					specialCard = Integer.toString(i);
					break;
				}

				if (i >= 11) {
					coercionCardNum = 10;
				} else {
					coercionCardNum = i;
				}

				Card card = new Card(pattern, specialCard, coercionCardNum);
				cards.add(card);
			}
		}

	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	// 테스트출력을 위한 메소드 오버라이딩.
	@Override
	public String toString() {
		for (Card card : cards) {
			System.out.println(card.toString());
		}
		return "";
	}

}
