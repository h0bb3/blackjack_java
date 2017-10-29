package BlackJack.model.rules;

public interface IRulesFactory {
	
	public IHitStrategy GetHitStrategy();
	
	public INewGameStrategy GetNewGameStrategy();
	
	public IWinStrategy GetWinStrategy();

}
