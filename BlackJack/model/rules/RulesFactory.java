package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy getHitRule() {
    return new BasicHitStrategy();
  }

  public INewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}