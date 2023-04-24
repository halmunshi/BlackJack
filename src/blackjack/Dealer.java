package blackjack;

/**
 *
 * @author hasanbasil
 */
public class Dealer extends Participant {
    private Card hiddenCard;

    public Dealer() {
        super();
    }

    public void setHiddenCard(Card hiddenCard) {
        this.hiddenCard = hiddenCard;
    }

    public Card getHiddenCard() {
        return hiddenCard;
    }

    public void playTurn(Deck deck) {
    while (calculateHandValue() <= 16) {
        Card newCard = deck.dealCard();
        if (newCard != null) {
            addCardToHand(newCard);
            if (calculateHandValue() > 21) {
                break;
            }
        } else {
            throw new IllegalStateException("Deck is empty");
        }
    }
}

    public void revealHiddenCard() {
    if (hiddenCard != null) {
        addCardToHand(hiddenCard);
        hiddenCard = null;
        }
    }

}

