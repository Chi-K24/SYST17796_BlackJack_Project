package wemakeit.blackjack;

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
