package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface INewGameStrategy {
    boolean newGame(Deck a_deck, Dealer a_dealer, Player a_player);
}