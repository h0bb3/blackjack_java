package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

  public boolean play(Game a_game, IView a_view) {
    a_view.displayWelcomeMessage();
    
    a_view.displayDealerHand(a_game.getDealerHand(), a_game.getDealerScore());
    a_view.displayPlayerHand(a_game.getPlayerHand(), a_game.getPlayerScore());

    if (a_game.isGameOver())
    {
        a_view.displayGameOver(a_game.isDealerWinner());
    }

    int input = a_view.getInput();
    
    if (input == 'p')
    {
        a_game.newGame();
    }
    else if (input == 'h')
    {
        a_game.hit();
    }
    else if (input == 's')
    {
        a_game.stand();
    }

    return input != 'q';
  }
}