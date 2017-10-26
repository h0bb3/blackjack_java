package BlackJack.model.rules;

import BlackJack.model.Player;

public class SoftHitStrategy implements IHitStrategy {
	
	private final int g_scoreLimit = 17;
	
	public boolean DoHit(Player a_dealer) {
		
		int count = a_dealer.CalcScore();
		
		if(count < g_scoreLimit) {
			return true;
		}
		
		else if(count == 17) {
			int numberOfAces = a_dealer.Aces();
			for (int i = 1; i <= numberOfAces; i++) {
				if (count - (i * 10) < g_scoreLimit) {
					return true;
				}
			}
		}
		
		return false;
	}

}
