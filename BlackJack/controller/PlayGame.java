package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.view.IView.GameInput;

public class PlayGame {

    public boolean play(Game a_game, IView a_view) {
        a_view.displayWelcomeMessage();

        a_view.displayDealerHand(a_game.getDealerHand(), a_game.getDealerScore());
        a_view.displayPlayerHand(a_game.getPlayerHand(), a_game.getPlayerScore());

        if (a_game.isGameOver()) {
            a_view.displayGameOver(a_game.isDealerWinner());
        }

        GameInput input = a_view.getInput();

        switch (input) {
            case PLAY: a_game.newGame(); break;
            case HIT: {
                a_game.hit();
                break;
            }

            case STAND: a_game.stand(); break;
        }



        return input != GameInput.QUIT;
    }
}