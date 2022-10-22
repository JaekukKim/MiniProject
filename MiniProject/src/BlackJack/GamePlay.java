package BlackJack;

import java.util.Scanner;

public class GamePlay {
	// 처음에 시작하고 카드를 생성 한 뒤 딜러가 카드를 섞고 카드를 2장씩 배분한다.
	public void start() {
		Scanner sc = new Scanner(System.in);
		Dealer dealer = new Dealer();
		Player player = new Player();
		CardDeck cardDeck = new CardDeck();
		Rules rules = new Rules();
		final int START_NUM = 2;
		boolean startGame = true;
		
		// 딜러가 카드덱에서 카드를 가져와서 딜러가 카드를 섞는다
		dealer.setCards(cardDeck.getCards());
		dealer.shuffle();
		// 섞은 카드 테스트코드 출력
		System.out.println(cardDeck.toString());
		// ㅇㅋ 굳 잘된다. (2022-10-20)
		
		// 이제 카드를 섞었으니 게임을 시작하고 딜러가 카드를 두장씩 돌린다.
		System.out.println("====테스트 절취선====");
		
		// 첫 턴 시작 서로 카드 2장씩.
		// 테스트 코드 메소드 변경완(2일씩이나 소요... 2022-10-22)
		// 테스트 코드 시작 (2022 10 22)
		rules.gameStart(player, dealer);
		
		rules.hit(player, dealer);
		// 왜 hit 메소드 안의 if문의 조건식부분 dealer.sumPoint메소드가 출력이 되는지 알 수가 없다. 도대체 왜? 뭐지?
		
		player.openCard();
		player.sumPoint();
		dealer.openCard();
		dealer.sumPoint();
		
		
		
		
	}

}
