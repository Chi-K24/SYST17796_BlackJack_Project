package blackjackgame;

/**
 *
 * @author Chi T. Le - 991185018>
 * @version 1.0
 * @since 09/06/2021
 */

public class BlackJack {
    
    public enum Suit {HEARTS, CLUBS, SPADES, DIAMONDS}
    
    public enum Value {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

    private Value value;
    private Suit suit;
    
    public static final String SUITS[] = {"HEARTS", "DIAMONDS", "SPADES", "CLUBS"};

    public BlackJack(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Value getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return this.suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

}
