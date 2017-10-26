package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {

	private Game a_game;
	private IView a_view;

	public PlayGame(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
	}

	public boolean Play() {
		a_view.DisplayWelcomeMessage();
		
		if (a_game.IsGameOver()) {
			a_view.DisplayGameOver(a_game.IsDealerWinner());
			System.exit(0);
		}

		InputChoices input = a_view.GetInput();
		
		switch (input) {
		case Play:
			a_game.NewGame();
			deal();
			break;
		case Hit:
			a_game.Hit();
			deal();
			break;
		case Stand:
			a_game.Stand();
			deal();
			break;
		case Quit: return false;
		}
		return true;

	}

	public void deal() {
		 try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
		 
	}
}