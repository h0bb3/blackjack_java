package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

    private Deck m_deck;
    private INewGameStrategy m_newGameRule;
    private IHitStrategy m_hitRule;
    private IGameWinStrategy m_gameWinRule;

    public Dealer(RulesFactory a_rulesFactory) {
        m_newGameRule = a_rulesFactory.getNewGameRule();
        m_hitRule = a_rulesFactory.getHitRule();
        m_gameWinRule = a_rulesFactory.getGameWinRule();
    }


    public boolean newGame(Player a_player) {
        if (m_deck == null || isGameOver()) {
            m_deck = new Deck();
            clearHand();
            a_player.clearHand();
            return m_newGameRule.newGame(m_deck, this, a_player);
        }
        return false;
    }

    public boolean hit(Player a_player) {
        if (m_deck != null && a_player.calcScore() < g_maxScore && !isGameOver()) {

            this.dealCard(a_player,m_deck.getCard(),true);
            return true;
        }
        return false;
    }

    public boolean isDealerWinner(Player a_player) {
        return m_gameWinRule.dealerWins(calcScore(),a_player.calcScore());
    }

    public boolean isGameOver() {
        if (m_deck != null && !m_hitRule.doHit(this)) {
            return true;
        }
        return false;
    }

    public boolean stand() {
        if (m_deck != null) {
            this.showHand();

            // to show the hidden dealer card, the observers need to be notified.
            // the question is: depending on the game strategy,
            // the dealer card is not always hidden, making this call unnecessary in some cases.

            super.notifyObservers();

            while(m_hitRule.doHit(this)) {

                this.dealCard(this,m_deck.getCard(),true);
            }
            return true;
        }
        return false;
    }

    public void dealCard(Player player, Card card, boolean show) {
        card.show(show);
        player.addCard(card);
        super.notifyObservers();
    }
}