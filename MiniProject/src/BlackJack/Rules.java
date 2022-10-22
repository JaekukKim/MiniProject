package BlackJack;

import java.util.Scanner;

public class Rules {
	// 첫 카드를 받고 두 카드의 합이 21이면 21인사람이 이긴다.
	// (플레이어건 딜러건) 카드의 합이 21이 넘어가면 버스트로 게임이 끝난다.
	// a의 값은 1이나 11로 유동적으로 고를수 있게한다.

	// 딜러의 hitPoint는 16의 값으로 고정이다. 스태틱파이널로 갑시다
	private static final int DEALER_HIT_POINT = 16;
	private static final int START_NUM = 2;

	// 게임 시작 메소드 작성
	public void gameStart(Player player, Dealer dealer) {
		
		System.out.println("카드를 두장씩 지급하겠습니다. 행운을 빕니다.");

		for (int i = 0; i < START_NUM; i++) {
			player.receiveCard(dealer.giveOneCard());
			dealer.receiveCard(dealer.giveOneCard());
		}

		player.openCard();
		player.sumPoint();
		dealer.openCard();
		dealer.sumPoint();
	}
	
	// hit이라고 하는 행위는 플레이어와 딜러의 공통적인 행위이이며 딜러에게만 적용되는 규칙이 따로있다. 그래서 딜러에게만 적용되는
	// 규칙을 hit에서 적용시켜서 하나의 메소드로 묶을 수 있다.
	public void hit (Player player, Dealer dealer) {
		Card card = dealer.cards.remove(0);
		player.receiveCard(card);
		
		if (dealer.sumPoint() <= DEALER_HIT_POINT) {
			card = dealer.cards.remove(0);
			dealer.receiveCard(card);
		} else {
			System.out.println("딜러의 점수 총 합이 17 이상이므로 카드를 더 이상 뽑지 않습니다.");
		}
		
	}

	// 첫 턴 이후 블랙잭 여부 판정.
	public void judgmentBlackJack(CardDeck cardDeck, Player player, Dealer dealer) {
		
		if (cardDeck.equals(dealer)) {
			System.out.println("플레이어의 블랙잭 승리!");
		}
		
	}

}
