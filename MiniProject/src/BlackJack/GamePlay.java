package BlackJack;

import java.util.Scanner;

public class GamePlay {
	// 처음에 시작하고 카드를 생성 한 뒤 딜러가 카드를 섞고 카드를 2장씩 배분한다.
	public void start() {

		// 딜러가 카드덱에서 카드를 가져와서 딜러가 카드를 섞는다
//		dealer.setCards(cardDeck.getCards());
//		dealer.shuffle();
		// 섞은 카드 테스트코드 출력
//		System.out.println(cardDeck.toString());
		// ㅇㅋ 굳 잘된다. (2022-10-20)

		// 이제 카드를 섞었으니 게임을 시작하고 딜러가 카드를 두장씩 돌린다.
		System.out.println("====테스트 절취선====");

		// 첫 턴 시작 서로 카드 2장씩.
		// 테스트 코드 메소드 변경완(2일씩이나 소요... 2022-10-22)
		// 테스트 코드 시작 (2022 10 22)
//		rules.gameStart(player, dealer);
//		rules.judgmentBlackJack(player, dealer);
//		
//		rules.hit(player, dealer);
//		
//		// 왜 hit 메소드 안의 if문의 조건식부분 dealer.sumPoint메소드가 출력이 되는지 알 수가 없다. 도대체 왜? 뭐지?
//		// 해결 : 어쩔수 없는거라 출력부 메소드를 따로 만들어 주었다.
//		player.openCard();
//		player.sumPoint();

		Scanner sc = new Scanner(System.in);

		while (true) {

			Dealer dealer = new Dealer();
			Player player = new Player();
			CardDeck cardDeck = new CardDeck();
			Rules rules = new Rules();
			while (true) {

				System.out.println("게임을 시작하겠나?");
				System.out.println("1. 게임시작  2.런");
				int num = sc.nextInt();
				if (num == 1) {
					System.out.println(
							"규칙을 설명한다.\n1.딜러의 패는 게임이 끝날때까지 공개되지 않는다." + "\n2.딜러의 카드의 총 합이 16이하일경우 Hit, 아닐시 Stay.\n");
					break;
				} else if (num == 2) {
					System.out.println("애송이로군");
					System.exit(1);
				} else {
					System.out.println("뭐라는건가?");
				}

			}
			
			player.betMoney(sc);

			dealer.setCards(cardDeck.getCards());
			dealer.shuffle();
			rules.gameStart(player, dealer);

			while (true) {
				System.out.println("\n1.Hit   2.Stay");
				int hitCase = sc.nextInt();
				if (hitCase == 1) {
					rules.hit(player, dealer);
					if (player.printSumPoint() > 21) {
						System.out.println("\n이런, 버스트가 나버렸구만, 아쉽지만 패배라네.");
						break;
					}
				} else if (hitCase == 2) {
					dealer.coercionHit();
					break;
				}
			}

			System.out.println("\n==게임 결과창==");
			player.openCard();
			player.sumPoint();
			dealer.openCard();
			dealer.sumPoint();
			
			rules.judgmentBlackJack(player, dealer);
			rules.gameWinner(player, dealer);

		}

	}

}
