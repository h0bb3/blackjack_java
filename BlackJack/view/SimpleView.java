package BlackJack.view;

import java.util.EnumSet;
import java.util.Scanner;

import BlackJack.controller.Choice;
import BlackJack.controller.Choice.Choices;

public class SimpleView implements IView 
{

  public void DisplayWelcomeMessage()
        {
          for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public Choices GetInput(){
        	Scanner scan = new Scanner(System.in); 
                for (Choices choices : EnumSet.allOf(Choices.class)) {
                   System.out.print(choices.ordinal()+1+". "+choices + "   ");
                  }
                System.out.println("");
       
                int choice = scan.nextInt(); 
               return Choices.values()[choice-1];
            }

        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
    }
