package BlackJack.view;

public class SwedishView implements IView 
    {
        public void displayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack Världen");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
        }
        
        public int getInput()
        {
          try {
            int c = System.in.read();
            while (c == '\r' || c =='\n') {
              c = System.in.read();
            }
            return c;
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return 0;
          }
        }
        
        public void displayCard(BlackJack.model.Card a_card)
        {
            if (a_card.getColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hjärter", "Spader", "Ruter", "Klöver" };
                String values[] =  
                    { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.getColor().ordinal()] + " " + values[a_card.getValue().ordinal()]);
            }
        }
        public void displayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Spelare", a_hand, a_score);
        }
        public void displayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Croupier", a_hand, a_score);
        }
        public void displayGameOver(boolean a_dealerIsWinner)
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

        private void displayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                displayCard(c);
            }
            System.out.println("Poäng: " + a_score);
            System.out.println("");
        }
    }
