package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * The Participant class represents a participant in the Blackjack game,
 * which can be either a player or a dealer.
 */
public abstract class Participant {
    protected List<Card> hand;

    // Constructor that initializes the participant's hand as an empty list
    public Participant() {
        hand = new ArrayList<>();
    }

    // Adds a card to the participant's hand
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // Clears the participant's hand
    public void clearHand() {
        hand.clear();
    }

    // Calculates the value of the participant's hand
    public int calculateHandValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : hand) {
            Rank rank = card.getRank();

            if (rank == Rank.ACE) {
                aceCount++;
            }

            value += rank.getValue();
        }

        for (int i = 0; i < aceCount; i++) {
            if (value > 21) {
                value -= 10;
            }
        }

        return value;
    }

    // Returns a string representation of the participant's hand
    public String getHand() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card).append(" ");
        }
        return sb.toString().trim();
    }
}
