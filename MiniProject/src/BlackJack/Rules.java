package BlackJack;

public class Rules {
	// 첫 카드를 받고 두 카드의 합이 21이면 21인사람이 이긴다.
	// (플레이어건 딜러건) 카드의 합이 21이 넘어가면 버스트로 게임이 끝난다.
	// a의 값은 1이나 11로 유동적으로 고를수 있게한다.

	// 딜러의 hitPoint는 16의 값으로 고정이다. 스태틱파이널로 갑시다
	private static final int BLACK_JACK_NUM = 21;
	private static final int START_NUM = 2;

	// 게임 시작 메소드 작성
	public void gameStart(Player player, Dealer dealer) {

		for (int i = 0; i < START_NUM; i++) {
			player.receiveCard(dealer.giveOneCard());
			dealer.receiveCard(dealer.giveOneCard());
		}

		player.openCard();
		player.sumPoint();
		System.out.println("\n**딜러의 카드는 게임이 끝나고 나서 공개됩니다.**");
	}

	// hit이라고 하는 행위는 플레이어와 딜러의 공통적인 행위이이며 딜러에게만 적용되는 규칙이 따로있다. 그래서 딜러에게만 적용되는
	// 규칙을 hit에서 적용시켜서 하나의 메소드로 묶을 수 있다.
	public void hit(Player player, Dealer dealer) {
		Card card = dealer.cards.remove(0);
		player.receiveCard(card);
		player.openCard();
		player.sumPoint();
		dealer.hit();

	}

	public void gameWinner(Player player, Dealer dealer) {
		if (player.printSumPoint() > dealer.printSumPoint()) {
			if (player.printSumPoint() < BLACK_JACK_NUM) {
				System.out.println("\n축하하네 자네의 승리라네!\n");
			} else if (player.printSumPoint() > BLACK_JACK_NUM) {
				System.out.print("\n이런 버스트가 났구만, 아쉽지만 자네의 패배라네");
				System.out.println("\n딜러의 승리로군.");
			}

		} else if (player.printSumPoint() == dealer.printSumPoint()) {
			System.out.println("\n다른의미로 운이 좋구만 무승부라네!\n");
		} else {
			if (dealer.printSumPoint() > BLACK_JACK_NUM) {
				System.out.println("\n딜러 버스트. 딜러의 패배라네.\n");
				System.out.println("\n축하하네 자네의 승리로군!\n");
			} else {
				System.out.println("\n딜러의 승리라네!\n");
			}

		}

	}

	// 첫 턴 이후 블랙잭 여부 판정.
	public void judgmentBlackJack(Player player, Dealer dealer) {
		if (player.printSumPoint() == BLACK_JACK_NUM) {
			System.out.println("\n블랙잭이 터져버렸구만! 완벽하게 이겼다네!");
		} else if (dealer.printSumPoint() == BLACK_JACK_NUM) {
			System.out.println("\n딜러의 블랙잭이로구만 아쉽지만 자네의 패배라네!");
		}
	}

}
