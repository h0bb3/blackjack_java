package BlackJack.view;

public interface IView {
    void displayWelcomeMessage();

    // to separate this from welcome message
    void displayInstructions();

    void displayCard(BlackJack.model.Card a_card);

    void displayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void displayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);

    void displayGameOver(boolean a_dealerIsWinner);

    GameInput getInput();

    enum GameInput {
        PLAY,
        HIT,
        STAND,
        QUIT,
        NONE
    }
}