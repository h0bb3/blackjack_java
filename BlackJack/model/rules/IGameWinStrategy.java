package BlackJack.model.rules;

public interface IGameWinStrategy {
    final int maxScore = 21;

    boolean dealerWins(int scoreDealer, int scorePlayer);
}
