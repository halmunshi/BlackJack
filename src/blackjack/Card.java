package blackjack;

/**
 * This class represents a playing card in a deck of cards.
 * It contains information about the card's suit and rank, as well as methods for getting the card's value and a string representation.
 * 
 * @author Hasan Al-munshi
 */
public class Card {
    private final Suit suit;
    private final Rank rank;

    // Constructor to create a Card object
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter method for suit
    public Suit getSuit() {
        return suit;
    }

    // Getter method for rank
    public Rank getRank() {
        return rank;
    }

    // Getter method for card value
    public int getValue() {
        return rank.getValue();
    }

    // Returns a string representation of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
