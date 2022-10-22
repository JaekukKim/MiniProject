package BlackJack;

public class Card {
	// 카드의 종류는 4종류(무늬), 1종류마다 13장이다(카드값). j q k 는 10이 넘어가나 10으로 값을 고정한다.

	private String cardPattern;
	private String cardNum;
	int coercionCardNum;
	
	public int getCoercionCardNum() {
		return coercionCardNum;
	}

	public void setCoercionCardNum(int coercionCardNum) {
		this.coercionCardNum = coercionCardNum;
	}

	public Card(String cardPattern, String cardNum, int coercionCardNum) {
		this.cardPattern = cardPattern;
		this.cardNum = cardNum;
		this.coercionCardNum = coercionCardNum;
	}

	public Card() {
		
	}

	// getter setter 생성.
	public String getCardPattern() {
		return cardPattern;
	}

	public void setCardPattern(String cardPattern) {
		this.cardPattern = cardPattern;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardNum() {
		return cardNum;
	}

	@Override
	public String toString() {
		return "[" + cardPattern + ", " + cardNum + "]";
	}


}
