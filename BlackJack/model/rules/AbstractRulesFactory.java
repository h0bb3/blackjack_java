package BlackJack.model.rules;

public interface AbstractRulesFactory {
    INewGameStrategy getNewGameRule();
    IHitStrategy getHitRule();
    IGameWinStrategy getGameWinRule();

}
