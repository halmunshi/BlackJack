package blackjack;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    protected List<Card> hand;

    public Participant() {
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

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


    public String getHand() {
        StringBuilder sb = new StringBuilder();
        for (Card card : hand) {
            sb.append(card).append(" ");
        }
        return sb.toString().trim();
    }
}
