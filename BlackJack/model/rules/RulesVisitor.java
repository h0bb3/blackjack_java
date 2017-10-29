package BlackJack.model.rules;

public interface RulesVisitor {
    void visit(IGameWinStrategy winStrategy);
    void visit(IHitStrategy hitStrategy);
    void visit(INewGameStrategy newGameStrategy);
}
