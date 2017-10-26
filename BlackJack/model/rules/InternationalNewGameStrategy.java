package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

	public boolean NewGame(Dealer a_dealer, Player a_player) {
		int i = 0;

		while (i < 3) {
			if (i == 1)
				a_dealer.DealCard(a_dealer, true);
			else {
				a_dealer.DealCard(a_player, true);
			}
			i++;
		}
		a_dealer.DealCard(a_dealer, false);

		return true;
	}
}