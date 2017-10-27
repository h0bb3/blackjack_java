package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import BlackJack.model.IObserver;

public class PlayGame extends IObserver{

	private Game a_game;
	private IView a_view;

	public PlayGame(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
		a_game.AddObservableValue(this);
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
			break;
		case Hit:
			a_game.Hit();
			break;
		case Stand:
			a_game.Stand();
			break;
		case Quit: return false;
		}
		return true;

	}

	public void update() {
		 try {
	            Thread.sleep(1500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
		a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
		a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
		 
	}
}