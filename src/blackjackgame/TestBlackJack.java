package blackjackgame;

import blackjackgame.BlackJack.Value;
import blackjackgame.BlackJack.Suit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Chi T. Le - 991185018>
 * @version 1.0
 * @since 09/06/2021
 */
public class TestBlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Create an array to hold 7 Cards 
        BlackJack[] hand = new BlackJack[7];
        
        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();

        // We'll use Random to generate random numbers
        Random random = new Random();

        for (int i = 0; i < hand.length; i++) {
            Value value = cardValues[random.nextInt(cardValues.length)];
            Suit suit = cardSuits[random.nextInt(cardSuits.length)];

            BlackJack BlackJack = new BlackJack(value, suit);
            hand[i] = BlackJack;
        }

        
                //***********************TESTER TO CHECK ENUM CLASS AND ARRAY********************************
                //Sucess - feel free to uncomment to test
        // print them out for debugging purposes
//        System.out.println("Here are the card in the hand");
//        for (BlackJack BlackJack : hand) {
//            System.out.printf("%s of %s\n", BlackJack.getValue(), BlackJack.getSuit());
//        }
//
//        // Now ask the user for a card
//        System.out.println("Pick a suit for your card");
//        for (int i = 0; i < cardSuits.length; i++) {
//            System.out.println((i + 1) + ": " + cardSuits[i]);
//        }
//        int suitPosition = input.nextInt() -1;
//
//        System.out.println("Enter a value");
//        for (int i = 0; i < cardValues.length; i++) {
//            System.out.println((i + 1) + ": " + cardValues[i]);
//        }
//        
//        int valuePosition = input.nextInt() - 1;
//
//        BlackJack userGuess = new BlackJack(cardValues[valuePosition], cardSuits[suitPosition]);
//        boolean match = false;
//        for (BlackJack blackjack : hand) {
//            if (blackjack.getValue() == userGuess.getValue() && blackjack.getSuit() == userGuess.getSuit()) {
//                match = true;
//                break;
//            }
//        }
//        String response = match ? "Right guess" : "No match";
//
//        System.out.println(response);
    }

}
