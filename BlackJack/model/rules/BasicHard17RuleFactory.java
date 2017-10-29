package BlackJack.model.rules;

public class BasicHard17RuleFactory implements AbstractRulesFactory {

  public IHitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy getNewGameRule() {
    return new InternationalNewGameStrategy();
  }

  public IGameWinStrategy getGameWinRule() { return new TiedGameDealerWinsStrategy(); }
}