package BlackJack.model.rules;

public class PlayerWinStrategy implements IWinStrategy {

	@Override
	public boolean IsDealerWinner(int a_playerScore, int a_dealerScore, int g_maxScore) {
		if (a_dealerScore > g_maxScore) {
			return false;
		}
		else if(a_playerScore > g_maxScore) {
			return true;
		}
		return a_dealerScore > a_playerScore;
	}

}
