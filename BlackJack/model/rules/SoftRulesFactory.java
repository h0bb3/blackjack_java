package BlackJack.model.rules;

public interface SoftRulesFactory {
	
	INewGameStrategy GetNewGameRule();

	IHitStrategy GetHitStrategy();
	
	IWinStrategy GetWinStrategy();

}
