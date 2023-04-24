package blackjack;


import blackjack.Card;
import blackjack.Participant;
import blackjack.Rank;
import blackjack.Suit;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GetHandTest {
    
    private Dealer dealer;

    @Before
    public void setUp() {
        dealer = new Dealer();
    }

    public void testCalculateHandValue_aceBoundary() {
        dealer.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        dealer.addCardToHand(new Card(Suit.HEARTS, Rank.TEN));
        dealer.addCardToHand(new Card(Suit.DIAMONDS, Rank.TEN));
        assertEquals(21, dealer.calculateHandValue());
    }

    @Test
    public void testGetHandWithEmptyHand() {
        assertEquals("", dealer.getHand());
    }

    @Test
    public void testGetHandWithOneCard() {
        Card card = new Card( Suit.HEARTS,Rank.TWO);
        dealer.addCardToHand(card);
        assertEquals("TWO of HEARTS", dealer.getHand());
    }

    @Test
    public void testGetHandWithMultipleCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Suit.SPADES,Rank.ACE));
        cards.add(new Card(Suit.CLUBS,Rank.KING));
        cards.add(new Card(Suit.DIAMONDS,Rank.THREE));
        for (Card card : cards) {
            dealer.addCardToHand(card);
        }
        assertEquals("ACE of SPADES KING of CLUBS THREE of DIAMONDS", dealer.getHand());
    }
}