package BlackJack;

import BlackJack.model.Game;
import BlackJack.model.rules.AmericanRuleFactory;
import BlackJack.model.rules.BasicHard17RuleFactory;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program {

    public static void main(String[] a_args) {

        Game g = new Game(new BasicHard17RuleFactory());
        //Game g = new Game(new AmericanRuleFactory());
        IView v = //new SimpleView();
                  new DutchView();
        PlayGame ctrl = new PlayGame(g,v);

        while (ctrl.play(g, v)) ;
    }
}