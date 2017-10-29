package BlackJack.view;

import BlackJack.model.rules.IGameWinStrategy;
import BlackJack.model.rules.IHitStrategy;
import BlackJack.model.rules.INewGameStrategy;
import BlackJack.model.rules.RulesVisitor;

public class DutchAbstractRuleVisitor implements RulesVisitor {
    @Override
    public void visit(IGameWinStrategy winStrategy) {
        System.out.println("Winstrategie: " + winStrategy.getClass().getSimpleName());
    }

    @Override
    public void visit(IHitStrategy hitStrategy) {
        System.out.println("Hitstrategie: " + hitStrategy.getClass().getSimpleName());

    }

    @Override
    public void visit(INewGameStrategy newGameStrategy) {
        System.out.println("Strategie voor nieuw spel: " + newGameStrategy.getClass().getSimpleName());
    }
}
