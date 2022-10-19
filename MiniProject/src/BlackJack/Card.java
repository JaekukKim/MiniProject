package BlackJack;

public class Card {
	private String cardKind;
	private String cardNum;
	
	public String getCardKind() {
		return cardKind;
	}
	public void setCardKind(String cardKind) {
		this.cardKind = cardKind;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	@Override
	public String toString() {
		return "Card [" + cardKind + ", " + cardNum + "]";
	}

	
}
