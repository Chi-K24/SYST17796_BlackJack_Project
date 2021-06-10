/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgame;

/**
 *
 * @author Chi T. Le - 991185018>
 */
public class TestBlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //Create an array to hold 7 BlackJacks 
        BlackJack[] hand  = new BlackJack[7];
        
        // We'll use Random to generate random numbers
        Random random = new Random();

        for (int i = 0; i< hand.length ; i++) {
        int value = random.nextInt(13) + 1;
            String suit = BlackJack.SUITS[random.nextInt(4)];

            BlackJack BlackJack = new BlackJack(value, suit);
            hand[i] = BlackJack;
        }

        // print them out for debugging purposes
        System.out.println ("Here are the BlackJacks in the hand");
        for (BlackJack BlackJack : hand) {
            System.out.printf("%d of %s\n", BlackJack.getValue(), BlackJack.getSuit());
        }

        // Now ask the user for a BlackJack
        System.out.println ("Pick a suit for your BlackJack");
        for (int i = 0; i < BlackJack.SUITS.length ; i++) {
            System.out.println((i + 1) + ": " + BlackJack.SUITS[i]);
        }
        int suit = input.nextInt();

        System.out.println ("Enter a value (1 to 13)");
        int value = input.nextInt();

        BlackJack userGuess = new BlackJack(value, BlackJack.SUITS[suit - 1]);
        boolean match = false;
        for (BlackJack BlackJack : hand) {
            if (BlackJack.getValue() == userGuess.getValue()
                    && BlackJack.getSuit().equals(userGuess.getSuit())) {
                match = true;
                break;
            }
        }

        String response = match ? "Right guess" : "No match";

        System.out.println (response);
    }

}


    

