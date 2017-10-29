package BlackJack.controller;

import BlackJack.model.Dealer;
import BlackJack.model.IObserver;
import BlackJack.model.Player;
import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.view.IView.GameInput;

public class PlayGame implements IObserver {
    private Game a_game;
    private IView a_view;

    public PlayGame(Game a_game, IView a_view) {
        this.a_game = a_game;
        this.a_view = a_view;
        this.a_game.registerObserver(this);

        a_view.displayWelcomeMessage();
        a_view.displayRulesOfGame(a_game.getRules());
    }

    public boolean play(Game a_game, IView a_view) {

        if (a_game.isGameOver()) {
            a_view.displayGameOver(a_game.isDealerWinner());
        }

        GameInput input = a_view.getInput();

        switch (input) {
            case PLAY:
                a_game.newGame();
                a_view.displayInstructions();
                break;

            case HIT:
                a_game.hit();
                a_view.displayInstructions();
                break;

            case STAND: a_game.stand(); break;
            case QUIT: return false;
        }
        return true;
    }

    @Override
    public void update() {
        try {
            Thread.sleep(1234);
        } catch (InterruptedException i) {
            System.err.println(i.getMessage());
        }

        a_view.displayDealerHand(a_game.getDealerHand(),a_game.getDealerScore());
        a_view.displayPlayerHand(a_game.getPlayerHand(),a_game.getPlayerScore());
    }
}