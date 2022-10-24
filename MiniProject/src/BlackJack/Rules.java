package BlackJack;

public class Rules {
	// 첫 카드를 받고 두 카드의 합이 21이면 21인사람이 이긴다.
	// (플레이어건 딜러건) 카드의 합이 21이 넘어가면 버스트로 게임이 끝난다.
	// a의 값은 1이나 11로 유동적으로 고를수 있게한다.

	// 딜러의 hitPoint는 16의 값으로 고정이다. 스태틱파이널로 갑시다
	private static final int BLACK_JACK_NUM = 21;
	private static final int START_NUM = 2;
	private static final int WINRATE = 2;
	private static final double BLACK_JACK_RATE = 1.5;

	// 게임 시작 메소드 작성
	public void gameStart(Player player, Dealer dealer, Rules rules) {

		for (int i = 0; i < START_NUM; i++) {
			player.receiveCard(dealer.giveOneCard());
			dealer.receiveCard(dealer.giveOneCard());
		}

		player.openCard();
		player.sumPoint();

		this.judgmentBlackJack(player, dealer);
	}

	// hit이라고 하는 행위는 플레이어와 딜러의 공통적인 행위이이며 딜러에게만 적용되는 규칙이 따로있다. 그래서 딜러에게만 적용되는
	// 규칙을 hit에서 적용시켜서 하나의 메소드로 묶을 수 있다.
	public void hit(Player player, Dealer dealer) {

		Card card = dealer.cards.remove(0);

		player.receiveCard(card);
		player.openCard();
		player.sumPoint();
		dealer.hit();
	
		this.judgmentBlackJack(player, dealer);

	}

	// 더블버스트 (둘다 버스트일시 플레이어의 패배) 같은 경우는 어느 한쪽을 지칭할수 없고 블랙잭이라는 게임 틀에
	// 예외 규칙으로 잡혀있는 조건이니만큼 규칙 객체에 생성한다.
	public void specialBust(Player player, Dealer dealer) {
		if (player.printSumPoint() > BLACK_JACK_NUM && dealer.printSumPoint() > BLACK_JACK_NUM) {
			System.out.println("블랙잭의 규칙은 알고있겠지? 아쉽지만 자네의 패배라네. 내가 해줄수 있는게 없군");
			System.out.println("금액 차감 : " + (player.playerMoney()));
			player.playerMoney -= player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}
	}

	public void gameWinner(Player player, Dealer dealer) {
		// 카드를 먼저 오픈 한 뒤 판별한다. ( 실제 블랙잭 규칙 의거 )
		player.openCard();
		player.sumPoint();
		dealer.openCard();
		dealer.sumPoint();

		// 버스트 조건 먼저 나열. (버스트일 경우에만 메소드 실행)
		player.bust(player, dealer);
		dealer.bust(player, dealer);

		// 더블 버스트
		this.specialBust(player, dealer);

		// 무승부일 경우
		if ((player.printSumPoint() < BLACK_JACK_NUM && dealer.printSumPoint() < BLACK_JACK_NUM)
				&& (player.printSumPoint() == dealer.printSumPoint())) {
			System.out.println("\n블랙잭 보다는 덜하지만 이것도 굉장한 우연일세, 이거 축하를 해줘야하나?");
			System.out.println("금액 차감 : " + player.playerMoney());
			player.playerMoney = (int) player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}
		
		if ((player.printSumPoint() < BLACK_JACK_NUM && dealer.printSumPoint() < BLACK_JACK_NUM)
				&& (player.printSumPoint() > dealer.printSumPoint())) {
			System.out.println("\n자네의 승리일세! 축하하네.");
			System.out.println("금액 획득! : " + (player.playerMoney()*2));
			player.playerMoney += ((int) player.playerMoney());
			System.out.println("현재 금액 : " + player.playerMoney());
			
		} else if ((player.printSumPoint() < BLACK_JACK_NUM && dealer.printSumPoint() < BLACK_JACK_NUM)
				&& (player.printSumPoint() < dealer.printSumPoint())){
			System.out.println("아쉽지만 자네의 패배일세.\n");
			System.out.println("금액 차감 : " + player.playerMoney());
			player.playerMoney -= (int) player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}

	}

	// 블랙잭 여부 판정.
	public void judgmentBlackJack(Player player, Dealer dealer) {
		
		if (player.printSumPoint() == BLACK_JACK_NUM) {
			player.openCard();
			player.sumPoint();
			dealer.openCard();
			dealer.sumPoint();
			System.out.println("\n블랙잭이 터져버렸구만! 완벽하게 이겼다네!\n");
			System.out.println("금액 획득! : " + player.playerMoney());
			player.playerMoney += ((int)(player.playerMoney() * BLACK_JACK_RATE));
			System.out.println("현재 금액 : " + player.playerMoney());
		} else if (dealer.printSumPoint() == BLACK_JACK_NUM) {
			player.openCard();
			player.sumPoint();
			dealer.openCard();
			dealer.sumPoint();
			System.out.println("\n딜러의 블랙잭이로구만 무슨일이 있어도 이기지 못할상황이라네!\n");
			System.out.println("금액 차감 : " + player.playerMoney());
			player.playerMoney -= (int) player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		} else if (player.printSumPoint() == BLACK_JACK_NUM && dealer.printSumPoint() == BLACK_JACK_NUM) {
			player.openCard();
			player.sumPoint();
			dealer.openCard();
			dealer.sumPoint();
			System.out.println("\n호오, 엄청난 우연이군 둘다 블랙잭이라니! 기분은 좋겠지만 무승부로 끝내야하네.\n");
			player.playerMoney = (int) player.playerMoney();
			System.out.println("현재 금액 : " + player.playerMoney());
		}

	}

}
