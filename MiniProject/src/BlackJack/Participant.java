package BlackJack;

public interface Participant {
	// 딜러와 플레이어의 공통된 메소드, 즉 행위가 많아서
	// 인터페이스로 관리하면 어떨까 라는 현직 친구의 피드백을 받았다.
	// 너무나도 좋은생각 같아서 인터페이스로 구현 한뒤 오버라이딩을 시켜줄 계획이다.
	
	void openCard();
	void receiveCard(Card card);
	int sumPoint();

}
