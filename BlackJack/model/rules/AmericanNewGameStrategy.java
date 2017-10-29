package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  @Override
  public void accept(RulesVisitor visitor) {
    visitor.visit(this);
  }

  public boolean newGame(Deck a_deck, Dealer a_dealer, Player a_player) {

    a_dealer.dealCard(a_player,a_deck.getCard(),true);
    a_dealer.dealCard(a_dealer,a_deck.getCard(),true);

    a_dealer.dealCard(a_player,a_deck.getCard(),true);
    a_dealer.dealCard(a_dealer,a_deck.getCard(),false);

    return true;
  }
}