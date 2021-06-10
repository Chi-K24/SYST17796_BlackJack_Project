package blackjackgame;

public class BlackJack {

    private int value;
    private String suit;
    
    public static final String SUITS[] = {"HEARTS", "DIAMONDS", "SPADES", "CLUBS"};

    public BlackJack(int value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return this.value;
    }

    /**
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    public String getSuit() {
        return this.suit;
    }

    /**
     *
     * @param suit
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

}
