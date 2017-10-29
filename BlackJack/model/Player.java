package BlackJack.model;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player {

  private List<Card> m_hand;
  private ArrayList<IObserver> m_observers;
  protected final int g_maxScore = 21;

  public Player()
  {
    m_hand = new LinkedList<Card>();
    m_observers = new ArrayList<IObserver>();
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear();
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand)
    {
      c.Show(true);
    }
  }
  
  public int CalcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    
    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  
  public int Aces() {
	  int aces = 0;
	  for (Card card : this.GetHand()) {
		  if (card.GetValue().equals("Ace")) {
			  aces = aces + 1;
		  }
	  }
	  return aces;
  }
  
  public void AddObserver(IObserver o) {
	  m_observers.add(o);
  }
  
  public void RemoveObserver(IObserver o) {
	 m_observers.remove(o);
  }
  
  public void NotifyObservers() {
	  for(IObserver m_observer : m_observers) {
		  m_observer.update();
	  }
  }
}