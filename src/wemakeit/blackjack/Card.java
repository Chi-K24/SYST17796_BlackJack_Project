package wemakeit.blackjack;

/**
 * A class that models Card in the game.
 *
 * @author Vitalii Ocheretianyi
 * @author dancye
 */
public class Card
{

   private Suit suit;
   private Value value;

   public Card (Suit suit, Value value)
   {
      this.value = value;
      this.suit = suit;
   }

   public Suit getSuit ()
   {
      return suit;
   }

   public Value getValue ()
   {
      return value;
   }

   @Override
   public String toString ()
   {
      return this.getSuit().toString() + "-" + this.value.toString();
   }

}
