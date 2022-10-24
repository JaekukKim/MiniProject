package BlackJack;

public interface Participant {
	public static final int BLACK_JACK_NUM = 21;
	
	void bust(Player player, Dealer dealer);
	void openCard();
	void receiveCard(Card card);
	int sumPoint();

}
