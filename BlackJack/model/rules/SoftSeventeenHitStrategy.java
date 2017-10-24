package BlackJack.model.rules;

import BlackJack.model.Player;

public class SoftSeventeenHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    @Override
    public boolean doHit(Player a_dealer) {
        int score = a_dealer.calcScore();
        if (score == g_hitLimit) {
            return a_dealer.hasAce();
        }
        return score < g_hitLimit;
    }
}
