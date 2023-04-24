package blackjack;

/**
 * 
 * @author Hasan Al-Munshi and Praba Manchanda
 * The Rank enum represents the possible ranks of a playing card.
 * Each rank has a corresponding value used for calculating the hand value.
 */
public enum Rank {
    ACE(11),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private final int value;

    // Constructor for each rank that sets its corresponding value
    Rank(int value) {
        this.value = value;
    }

    // Returns the value of the rank
    public int getValue() {
        return value;
    }
}
