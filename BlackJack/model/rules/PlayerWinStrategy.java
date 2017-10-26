package BlackJack.model.rules;

public class PlayerWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(int a_playerScore, int a_dealerScore, int g_maxScore) {
		if (a_playerScore > g_maxScore) {
			return true;
		}
		else if(a_dealerScore > g_maxScore) {
			return false;
		}
		return a_dealerScore > a_playerScore;
	}

}
