package BlackJack.model.rules;

import BlackJack.model.Player;

class BasicHitStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean doHit(Player a_dealer) {
        return a_dealer.calcScore() < g_hitLimit;
    }
}