package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winStrat;

  public Dealer(IRulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameStrategy();
    m_hitRule = a_rulesFactory.GetHitStrategy();
    m_winStrat = a_rulesFactory.GetWinStrategy();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      DealCard(a_player, true);
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    return m_winStrat.IsDealerWinner(a_player.CalcScore(), this.CalcScore(), g_maxScore);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public boolean Stand() { //updated from sequence diagram 
	if (m_deck != null) {
		ShowHand();
	}
	while(m_hitRule.DoHit(this)) {
		Hit(this);
	}
	return false;
  }
  
  public void DealCard(Player a_player, boolean bool) {
	  Card c = m_deck.GetCard();
	  c.Show(bool);
	  a_player.DealCard(c); 
	  NotifyObservers();
  }
}
