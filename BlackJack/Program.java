package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.BasicRulesFactory;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game(new BasicRulesFactory());
    IView v = new SimpleView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(g,v);
    
    while (ctrl.Play());
  }
}