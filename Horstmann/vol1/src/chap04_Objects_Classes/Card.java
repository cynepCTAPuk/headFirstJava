package chap04_Objects_Classes;

/**
 * The {@code Card} class represents a playing card, such as "Queen of Hearts". 
 * A card has a suit (Diamond, Heart, Spade or Club) and 
 * a value (1 = Ace, 2 . . . 10, 11 = Jack, 12 = Queen, 13 = King)
 *
 * @author Cay Horstmann
 * @version 1.13 2018-04-10
 * @link chap04_Objects_Classes.CalendarTest
 * @see <a href="www.horstmann.com/corejava.html">The Core Java home page</a>
 * @see "Core Java volume 1"
 * @since 2019-08-20
 */
public class Card {
    /**
     * The "Diamond" card suit
     */
    public static final int DIAMOND = 0;
    /**
     * The "Hearts" card suit
     */
    public static final int HEARTS = 1;
    /**
     * The "Spade" card suit
     */
    public static final int SPADE = 2;
    /**
     * The "Club" card suit
     */
    public static final int CLUB = 3;

    private int value;
    private int suit;

    public Card(int value, int suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }
}

