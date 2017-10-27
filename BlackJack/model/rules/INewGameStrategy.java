package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

public interface INewGameStrategy {
    boolean NewGame(Dealer a_dealer, Player a_player);
}