package wemakeit.blackjack;

/**
 * A class that controls the Blackjack game behavior
 *
 * @author Vitalii Ocheretianyi
 * @author Chi Le
 * @author Jieun Jung
 * @author Yujin Eun
 */
import java.util.Scanner;

public class Blackjack
{

   public static boolean validator (String input)
   {
      System.out.println("You answered: " + input);
      return !input.equals("n");
   }

   public static void play (Scanner userInput, Player playerHand)
   {
      // create an initial group of cards
      GroupOfCards initDeck;
      while (playerHand.getMoney() > 0) {
         // Play on!
         // Ask the players to bet
         System.out.println("Hello " + playerHand.getName()
             + " you have $" + playerHand.getMoney() + ", how much would you like to bet?");
         double playerBet = userInput.nextDouble();
         if (playerBet > playerHand.getMoney()) {
            System.out.println("You tried to bet more than you have!"
                + "Mr.Tony(the owner of casino) is going to speak to you soon!");
            break;
         }
         while (true) {
            // repopulate the initial deck of cards
            initDeck = new GroupOfCards();
            // empty hand
            playerHand.clearCards();
            // Start dealing
            // The Player receives 2 cards
            playerHand.addCard(initDeck.getCard());
            playerHand.addCard(initDeck.getCard());
            // Display player hand
            System.out.println("Your hand: " + playerHand);
            System.out.println("The value of your hand is: " + playerHand.cardsValue());
            // The dealer receives 2 cards
            Player dealerHand = new Player("Dealer");
            dealerHand.addCard(initDeck.getCard());
            dealerHand.addCard(initDeck.getCard());
            // Display dealer hand
            System.out.println("Dealer hand: " + dealerHand.getCard(0).toString());
            System.out.println("Would you like to hit(1) or stand(2)");
            int response = userInput.nextInt();

            // if player hits
            if (response == 1) {
               // add a new card to player
               playerHand.addCard(initDeck.getCard());
               // show all the cards after the update
               System.out.println("Your updated hand has: " + playerHand);
               // show the value of players hand
               System.out.println("The value of your hand is: " + playerHand.cardsValue());
               // Reveal the dealer cards
               System.out.println("Dealer Cards are valued at: " + dealerHand.cardsValue());
               System.out.println("Dealer Cards: " + dealerHand);
               if (dealerHand.cardsValue() > playerHand.cardsValue()) {
                  System.out.println("Dealer beats you!");
                  playerHand.setMoney(playerHand.getMoney() - playerBet);
                  break;
               }
            }
            // if player stands
            if (response == 2) {
               // Dealer draws to 16, stand at 17
               while (dealerHand.cardsValue() < 17) {
                  dealerHand.addCard(initDeck.getCard());
                  System.out.println("Dealer hand: " + dealerHand.getCard(0).toString());
               }
               System.out.println("Dealer's hand is valued at: " + dealerHand.cardsValue());
            }

            // Bust if > 21
            if (playerHand.cardsValue() > 21) {
               System.out.println("Bust! Your hand is currently valued at " + playerHand.cardsValue());
               playerHand.setMoney(playerHand.getMoney() - playerBet);
               break;
            }
            // if dealer busts
            else if (dealerHand.cardsValue() > 21) {
               System.out.println("Dealer busts! You win.");
               playerHand.setMoney(playerHand.getMoney() + playerBet);
               break;
            }
            // if draw
            else if (playerHand.cardsValue() == dealerHand.cardsValue()) {
               System.out.println("Push");
               break;
            }
            // if value of cards player holds is bigger than the dealer's
            else if (playerHand.cardsValue() > dealerHand.cardsValue()) {
               System.out.println("You win the hand!");
               playerHand.setMoney(playerHand.getMoney() + playerBet);
               break;
            }
            // if dealer's cards have more value
            else if (playerHand.cardsValue() < dealerHand.cardsValue()) {
               System.out.println("Dealer wins the hand!");
               playerHand.setMoney(playerHand.getMoney() - playerBet);
               break;
            }
            System.out.println("End of hand.");
            break;
         }
      }
   }

   public static void main (String[] args)
   {
      // Greets the player/user
      System.out.println("Welcome to our Blackjack card game!");
      // Ask user to input
      System.out.println("What is your name?");
      // get username and with each iteration of the loop on line 122 pass this as a parameter to player class
      // when instantiating it
      Scanner sc = new Scanner(System.in);
      String userName = sc.nextLine();

      boolean letsPlay = true;
      while (letsPlay) {
         play(sc, new Player(userName));
         System.out.print("Would you like to play again?(y/n): ");
         String checkerValue = sc.next();
         letsPlay = validator(checkerValue);
      }

   }
}
