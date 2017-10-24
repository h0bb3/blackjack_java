package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy {
    boolean doHit(Player a_dealer);
}