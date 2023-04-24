package blackjack;

/**
 * @author Hasan Al-Munshi and Praba Manchanda
 * The Dealer class represents a dealer in the game of Blackjack. It extends the Participant abstract class,
 * which provides common methods and properties that are used by both the Dealer and Player classes.
 */
public class Dealer extends Participant {
    private Card hiddenCard; // A variable to store the dealer's hidden card

    /**
     * Creates a new instance of the Dealer class, which initializes the hand property inherited from the Participant class.
     */
    public Dealer() {
        super();
    }

    /**
     * Sets the dealer's hidden card.
     * @param hiddenCard The card that is to be hidden from the player.
     */
    public void setHiddenCard(Card hiddenCard) {
        this.hiddenCard = hiddenCard;
    }

    /**
     * Gets the dealer's hidden card.
     * @return The card that is currently hidden from the player.
     */
    public Card getHiddenCard() {
        return hiddenCard;
    }

    /**
     * The playTurn method represents the dealer's turn in the game of Blackjack. The dealer will keep drawing cards from the deck
     * until the total value of their hand is greater than or equal to 17. If the total value of the dealer's hand exceeds 21, the
     * dealer will "bust" and the game will end.
     * @param deck The deck of cards used in the game.
     */
    public void playTurn(Deck deck) {
        while (calculateHandValue() <= 16) { // Keep drawing cards until the hand value is greater than or equal to 17
            Card newCard = deck.dealCard(); // Draw a new card from the deck
            if (newCard != null) { // Check if the deck is empty
                addCardToHand(newCard); // Add the new card to the dealer's hand
                if (calculateHandValue() > 21) { // Check if the dealer busts
                    break; // If the dealer busts, end the game
                }
            } else {
                throw new IllegalStateException("Deck is empty"); // If the deck is empty, throw an exception
            }
        }
    }

    /**
     * The revealHiddenCard method reveals the dealer's hidden card to the player.
     * It adds the hidden card to the dealer's hand and sets the hiddenCard variable to null.
     */
    public void revealHiddenCard() {
        if (hiddenCard != null) { // Check if there is a hidden card
            addCardToHand(hiddenCard); // Add the hidden card to the dealer's hand
            hiddenCard = null; // Set the hiddenCard variable to null, since the card has been revealed
        }
    }

}
