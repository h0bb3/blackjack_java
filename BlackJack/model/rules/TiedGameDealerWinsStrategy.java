package BlackJack.model.rules;

public class TiedGameDealerWinsStrategy implements IGameWinStrategy {
    @Override
    public boolean dealerWins(int scoreDealer, int scorePlayer) {
        if (scorePlayer > maxScore)
            return true;
        else if (scoreDealer > maxScore)
            return false;
        else return (scoreDealer >= scorePlayer);
    }
}
