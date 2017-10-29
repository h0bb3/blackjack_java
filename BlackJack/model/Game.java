package BlackJack.model;

import BlackJack.model.rules.AbstractRulesFactory;

public class Game {

    private Dealer m_dealer;
    private Player m_player;
    private AbstractRulesFactory gameRules;

    public Game(AbstractRulesFactory rulesFactory) {
        m_dealer = new Dealer(rulesFactory);
        //m_dealer = new Dealer(new BlackJack.model.rules.AmericanRuleFactory());
        m_player = new Player();
        this.gameRules = rulesFactory;
    }


    public boolean isGameOver() {
        return m_dealer.isGameOver();
    }

    public boolean isDealerWinner() {
        return m_dealer.isDealerWinner(m_player);
    }

    public boolean newGame() {
        return m_dealer.newGame(m_player);
    }

    public boolean hit() {
        return m_dealer.hit(m_player);
    }

    public boolean stand()
    {
        return m_dealer.stand();
    }

    public Iterable<Card> getDealerHand() {
        return m_dealer.getHand();
    }

    public Iterable<Card> getPlayerHand() {
        return m_player.getHand();
    }

    public int getDealerScore() {
        return m_dealer.calcScore();
    }

    public int getPlayerScore() {
        return m_player.calcScore();
    }

    public void registerObserver(IObserver observer) {
        m_player.addObserver(observer);
        m_dealer.addObserver(observer);
    }

    public AbstractRulesFactory getRules() {
        return gameRules;
    }

}