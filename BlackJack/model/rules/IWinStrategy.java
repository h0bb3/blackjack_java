package BlackJack.model.rules;

public interface IWinStrategy {
	
	boolean IsDealerWinner(int a_playerScore, int a_dealerScore, int g_maxScore);


}
