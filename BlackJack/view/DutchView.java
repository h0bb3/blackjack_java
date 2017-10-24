package BlackJack.view;

import BlackJack.model.Card;

public class DutchView implements IView {
    @Override
    public void displayWelcomeMessage() {
        System.out.println("Hallo, BlackJack-wereld!");
        System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-");
        System.out.println("Typ 'n' voor een nieuw spel, 'h' voor hit, 's' voor stand en 'a' om af te sluiten.");
    }

    @Override
    public void displayCard(Card a_card) {
        if (a_card.getColor() == BlackJack.model.Card.Color.Hidden)
        {
            System.out.println("Verborgen kaart");
        }
        else
        {
            String colors[] =
                    { "Harten", "Schoppen", "Ruiten", "Klaver" };
            String values[] =
                    { "twee", "drie", "vier", "vijf", "zes", "zeven", "acht", "negen", "tien", "boer", "vrouw", "koning", "aas" };
            System.out.println("" + colors[a_card.getColor().ordinal()] + " " + values[a_card.getValue().ordinal()]);
        }
    }

    @Override
    public void displayPlayerHand(Iterable<Card> a_hand, int a_score) {
        displayHand("Speler", a_hand, a_score);
    }

    @Override
    public void displayDealerHand(Iterable<Card> a_hand, int a_score) {
        displayHand("Deler", a_hand, a_score);

    }

    @Override
    public void displayGameOver(boolean a_dealerIsWinner) {
        {
            System.out.println("Afgelopen: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Deler wint!");
            }
            else
            {
                System.out.println("Jij wint!");
            }
        }
    }

    @Override
    public GameInput getInput() {
        {
            try {
                int c = System.in.read();
                while (c == '\r' || c =='\n') {
                    c = System.in.read();
                }
                switch (c) {
                    case 'n': return GameInput.PLAY;
                    case 'h': return GameInput.HIT;
                    case 's': return GameInput.STAND;
                    case 'a': return GameInput.QUIT;
                }
            } catch (java.io.IOException e) {
                System.out.println("" + e);
                return GameInput.NONE;
            }
        }
        return GameInput.NONE;
    }

    private void displayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " heeft: " + a_score);
        for(BlackJack.model.Card c : a_hand)
        {
            displayCard(c);
        }
        System.out.println("Punten: " + a_score);
        System.out.println("");
    }
}
