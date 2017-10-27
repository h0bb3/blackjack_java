package BlackJack.view;

import java.util.Scanner;

import BlackJack.controller.InputChoices;


public class SwedishView implements IView 
    {
		private Scanner scan = new Scanner(System.in);
        public void DisplayWelcomeMessage()
        {

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
        }
        
        public InputChoices GetInput() {
    		try {
    			String c = scan.next();

    			if (c.equals("p")) {
    				return InputChoices.Play;
    			} else if (c.equals("s")) {
    				return InputChoices.Stand;
    			} else if (c.equals("h")) {
    				return InputChoices.Hit;
    			} else if (c.equals("q")) {
    				return InputChoices.Quit;
    			}
    		} catch (Exception e) {
    			System.out.println("Ogiltig val!" + e);
    		}
    		return null;
    	}
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Spelare", a_hand, a_score);
        }
        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Croupier", a_hand, a_score);
        }
        public void DisplayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }
    }
