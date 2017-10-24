package BlackJack.view;
import BlackJack.controller.Choice.Choices; 
public interface IView
{
  void DisplayWelcomeMessage();
  Choices GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOver(boolean a_dealerIsWinner);
}