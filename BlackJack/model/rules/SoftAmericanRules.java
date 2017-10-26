package BlackJack.model.rules;

public class SoftAmericanRules implements SoftRulesFactory{

	@Override
	public INewGameStrategy GetNewGameRule() {
		return new AmericanNewGameStrategy();
	}

	@Override
	public IHitStrategy GetHitStrategy() {
		return new SoftHitStrategy();
	}

	@Override
	public IWinStrategy GetWinStrategy() {
		return new PlayerWinStrategy();
	}

}
