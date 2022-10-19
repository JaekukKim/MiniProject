package BlackJack;

public class GameStart {
	public void play() {
		System.out.println("게임을 시작합니다");
		Dealer dealer = new Dealer();
		Gamer gamer = new Gamer();
		Rules rules = new Rules();
		CardDeck cardDeck = new CardDeck();
		
		System.out.println("딜러가 카드를 섞습니다.");
		dealer.setCardList(cardDeck.cards);
		dealer.shuffle();
		
		// 테스트 코드
		System.out.println(cardDeck.toString());
		
		// 각각 카드를 두장씩 받는다.
		
		
	}
	

}
