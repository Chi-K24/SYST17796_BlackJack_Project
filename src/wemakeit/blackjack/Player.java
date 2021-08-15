package wemakeit.blackjack;

/**
 * You may need this class to create a Dealer and a Gamer class
 * I don't know how useful it is going to be, since you can just use hands
 * instead of this class
 * But since you're the won working on Blackjack.java file - it is up to you to
 * decide
 * Currently there is a variable hand of class Hand, but it does not have to be
 * a variable of the player class
 */
public abstract class Player
{

   private String name; //the unique name for this player
   private Hand hand; // the players unique hand

   /**
    * A constructor that allows you to set the player's unique ID
    *
    * @param name the unique ID to assign to this player.
    */
   public Player (String name)
   {
      this.name = name;
   }

   /**
    * @return the player name
    */
   public String getName ()
   {
      return name;
   }

   /**
    * Ensure that the playerID is unique
    *
    * @param name the player name to set
    */
   public void setName (String name)
   {
      this.name = name;
   }

   /**
    * The method to be overridden when you subclass the Player class with your
    * specific type of Player and filled in
    * with logic to play your game.
    */
   public abstract void play ();
}
