package wemakeit.blackjack;

/**
 * A class that models a deck of cards in the game.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Vitalii Ocheretianyi
 * @author Chi Le
 * @author Jieun Jung
 * @author Yujin Eun
 */

import java.util.ArrayList;
import java.util.Random;

public class GroupOfCards
{

   //The group of cards, stored in an ArrayList
   private ArrayList<Card> cards = new ArrayList<>();

   public GroupOfCards ()
   {
      // a constructor for group of cards class

      // generate an initial deck of 52 cards
      // go through each available suit
      for (Suit cardSuit : Suit.values()) {
         // and match it with every available value
         for (Value cardValue : Value.values()) {
            // and combine them in one object (new Card(...))
            // and add it to class immediately: this.cards.add(...)
            this.cards.add(new Card(cardSuit, cardValue));
         }
      }
      // create a temporary deck
      ArrayList<Card> tmpDeck = new ArrayList<>();
      // shuffle cards
      Random random = new Random();
      int randomCardIndex = 0;
      int originalSize = this.cards.size();
      for (int i = 0; i < originalSize; i++) {
         // Generate Random Index
         randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
         tmpDeck.add(this.cards.get(randomCardIndex));
         //remove card from original deck
         this.cards.remove(randomCardIndex);
      }
      // change the initial deck to the shuffled deck,
      // they contain the same cards, just in a different order
      this.cards = tmpDeck;
   }


   /**
    * @return a random card
    * delete it from the deck
    * since it is already in of the players hand
    */
   public Card getCard ()
   {
      Random rand = new Random();
      Card card = this.cards.get(rand.nextInt(this.cards.size()));
      this.cards.remove(card);
      return card;
   }
}
