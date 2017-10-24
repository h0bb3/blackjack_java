package BlackJack.model.rules;

public class TiedGameDealerWinsStrategy implements IGameWinStrategy {
    @Override
    public boolean dealerWins(int scoreDealer, int scorePlayer) {

        // with help of DeMorgan's laws this could've been simplified.
        if (scorePlayer > maxScore)
            return true;
        else if (scoreDealer > maxScore)
            return false;
        else return (scoreDealer >= scorePlayer);
    }
}
