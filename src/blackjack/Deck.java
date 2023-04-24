package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hasan Al-Munshi and Praba Manchanda
 * The Deck class represents a deck of cards used in the Blackjack game.
 */
public class Deck {
    private final List<Card> cards;

    // Constructor that creates a new deck with all possible combinations of suits and ranks
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    // Shuffles the cards in the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Deals a card from the deck
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }
}
