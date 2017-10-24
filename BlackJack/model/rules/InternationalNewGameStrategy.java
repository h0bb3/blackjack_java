package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
import BlackJack.model.Card;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean newGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    Card c;
  
    c = a_deck.getCard();
    c.show(true);
    a_player.dealCard(c);
  
    c = a_deck.getCard();
    c.show(true);
    a_dealer.dealCard(c);
  
    c = a_deck.getCard();
    c.show(true);
    a_player.dealCard(c);
  
    return true;
  }
}