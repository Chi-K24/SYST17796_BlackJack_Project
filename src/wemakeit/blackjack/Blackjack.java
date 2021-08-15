package wemakeit.blackjack;
import java.util.Scanner;
/**
 * @author Eun, Yujin
 * @author Jung, Jieun
 * @author Le, Chi
 * @author Ocheretianyi, Vitalii
 */
public class Blackjack
{
   private static String name;

   public static boolean validator (String input)
   {
      System.out.println("You answered: " + input);
      boolean isRunning = true;
      if (input.equals("n")) {
         isRunning = false;
      }
      return isRunning;
   }

   public static void play (Scanner userInput)
   {
      // create an initial group of cards
      GroupOfCards initDeck = new GroupOfCards();
      GroupOfCards playerDeck = new GroupOfCards();
      GroupOfCards dealerDeck = new GroupOfCards();
      double playerMoney = 100.00;
      while (playerMoney > 0) {
         // Play on!
         // Ask the players to bet
         System.out.println("Hello " + name + " you have $" + playerMoney + ", how much would you like to bet?");
         double playerBet = userInput.nextDouble();
         if (playerBet > playerMoney) {
            System.out.println("You tried to bet more than you have!"
                + "Mr.Tony(the owner of casino) is going to speak to you soon!");
            break;
         }
         while (true) {
            // Start dealing
            // The Player receives 2 cards
            Hand playerHand = new Hand();
            playerHand.addCard(playerDeck.getCard());
            playerHand.addCard(playerDeck.getCard());
            // Display player hand
            System.out.println("Your hand: " + playerHand.toString());
            System.out.println("The value of your hand is: " + playerHand.cardsValue());
            // The dealer receives 2 cards
            Hand dealerHand = new Hand();
            dealerHand.addCard(dealerDeck.getCard());
            dealerHand.addCard(dealerDeck.getCard());
            // Display dealer hand
            System.out.println("Dealer hand: " + dealerHand.getCard(0).toString());
            System.out.println("Whould you like to hit(1) or stand(2)");
            int response = userInput.nextInt();

            // if player hits
            if (response == 1) {
               playerHand.addCard(playerDeck.getCard());
               System.out.println("Your updated hand has: " + playerHand.toString());
               System.out.println("The value of your hand is: " + playerHand.cardsValue());
               // Reveal the dealer cards
               System.out.println("Dealer Cards are valued at: " + dealerHand.cardsValue());
               System.out.println("Dealer Cards: " + dealerHand.toString());
               if (dealerHand.cardsValue() > playerHand.cardsValue()) {
                  System.out.println("Dealer beats you!");
                  playerMoney -= playerBet;
                  break;
               }
            }
            if (response == 2) {
               // Dealer draws to 16, stand at 17
               while (dealerHand.cardsValue() < 17) {
                  dealerHand.addCard(dealerDeck.getCard());
                  System.out.println("Dealer hand: " + dealerHand.getCard(0).toString());
               }
               System.out.println("Dealer's hand is valued at: " + dealerHand.cardsValue());
            }

            // Bust if > 21
            if (playerHand.cardsValue() > 21) {
               System.out.println("Bust! Your hand is currently valued at " + playerHand.cardsValue());
               playerMoney -= playerBet;
               break;
            }
            else if (dealerHand.cardsValue() > 21) {
               System.out.println("Dealer busts! You win.");
               playerMoney += playerBet;
               break;
            }
            else if (playerHand.cardsValue() == dealerHand.cardsValue()) {
               System.out.println("Push");
               break;
            }
            else if (playerHand.cardsValue() > dealerHand.cardsValue()) {
               System.out.println("You win the hand!");
               playerMoney += playerBet;
               break;
            }
            else if (playerHand.cardsValue() < dealerHand.cardsValue()) {
               System.out.println("Dealer wins the hand!");
               playerMoney -= playerBet;
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
      Scanner sc = new Scanner(System.in);
      name = sc.nextLine();
      boolean letsPlay = true;
      while (letsPlay) {
         play(sc);
         System.out.print("Would you like to play again?(y/n): ");
         String checkerValue = sc.next();
         letsPlay = validator(checkerValue);
      }

   }
}
