package BlackJack.model.rules;

public class BasicRulesFactory implements IRulesFactory {

	
	public IHitStrategy GetHitStrategy() {
		return new BasicHitStrategy();
	}


	public INewGameStrategy getNewGameStrategy() {
		return new AmericanNewGameStrategy();
	}


	public IWinStrategy GetWinStrategy() {
		return new PlayerWinStrategy();
	}

}
