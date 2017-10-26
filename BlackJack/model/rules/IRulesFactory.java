package BlackJack.model.rules;

public interface IRulesFactory {
	
	public IHitStrategy GetHitStrategy();
	
	public INewGameStrategy getNewGameStrategy();
	
	public IWinStrategy GetWinStrategy();

}
