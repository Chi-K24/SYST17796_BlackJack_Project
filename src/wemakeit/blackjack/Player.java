package wemakeit.blackjack;

/**
 * A class that models Player in the game.
 *
 * @author Vitalii Ocheretianyi
 * @author Chi Le
 * @author Jieun Jung
 * @author Yujin Eun
 */


import java.util.ArrayList;

public class Player
{
   private ArrayList<Card> cards = new ArrayList<>();
   private double playerMoney = 100;
   private String name;

   Player (String name)
   {
      this.name = name;
   }

   /**
    * @param card that is going to be added to the players hand
    */
   public void addCard (Card card)
   {
      this.cards.add(card);
   }

   /**
    *
    * @param money in players pocket
    */
   public void setMoney (double money)
   {
      this.playerMoney = money;
   }



   /**
    *
    * clear hand
    */
   public void clearCards ()
   {
      this.cards = new ArrayList<>();
   }

   /**
    *
    * @return the amount of money in players pocket
    */
   public double getMoney ()
   {
      return playerMoney;
   }

   /**
    * @return username
    */
   public String getName ()
   {
      return this.name;
   }

   /**
    * @return the value of a current hand
    */
   public int cardsValue ()
   {
      int totalValue = 0;
      int aces = 0;
      for (Card card : this.cards) {
         switch (card.getValue()) {
            case Two:
               totalValue += 2;
               break;
            case Three:
               totalValue += 3;
               break;
            case Four:
               totalValue += 4;
               break;
            case Five:
               totalValue += 5;
               break;
            case Six:
               totalValue += 6;
               break;
            case Seven:
               totalValue += 7;
               break;
            case Eight:
               totalValue += 8;
               break;
            case Nine:
               totalValue += 9;
               break;
            case Ten:
            case Jack:
            case Queen:
            case King:
               totalValue += 10;
               break;
            case Ace:
               aces += 1;
               break;
         }
         for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
               totalValue += 1;
            }
            else {
               totalValue += 11;
            }
         }
      }
      return totalValue;
   }

   public Card getCard (int i)
   {
      return this.cards.get(i);
   }

   public void moveAllToDeck (Player moveTo)
   {
      int thisDeckSize = this.cards.size();
      // put card into moveTo deck
      for (int i = 0; i < thisDeckSize; i++) {
         moveTo.addCard(this.getCard(i));
      }
      for (int i = 0; i < thisDeckSize; i++) {
         this.removeCard(0);
      }
   }

   public void removeCard (int i)
   {
      this.cards.remove(i);
   }

   /**
    * @return String that holds the names of the cards in a hand
    */
   @Override
   public String toString ()
   {
      StringBuilder cardListOutput = new StringBuilder();
      int i = 0;
      for (Card aCard : this.cards) {
         cardListOutput.append("\n").append("-").append(aCard.toString());
      }
      return cardListOutput.toString();
   }
}
