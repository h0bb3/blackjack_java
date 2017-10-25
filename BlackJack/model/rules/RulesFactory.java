package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy getHitRule() {
    return new SoftSeventeenHitStrategy();
  }

  public INewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }

  public IGameWinStrategy getGameWinRule() { return new TiedGameDealerWinsStrategy(); }
}