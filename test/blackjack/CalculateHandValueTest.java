package blackjack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// This JUnit test class tests the Particapant class's calculateHandValue() method
public class CalculateHandValueTest {
    private Dealer dealer;

    // Initialize the dealer object before each test
    @Before
    public void setUp() {
        dealer = new Dealer();
    }

    // Test that the calculateHandValue() method correctly calculates the hand value with no aces
    @Test
    public void testCalculateHandValue_noAces() {
        dealer.addCardToHand(new Card(Suit.CLUBS, Rank.TEN));
        dealer.addCardToHand(new Card(Suit.HEARTS, Rank.NINE));
        assertEquals(19, dealer.calculateHandValue());
    }

    // Test that the calculateHandValue() method correctly calculates the hand value with one ace
    @Test
    public void testCalculateHandValue_oneAce() {
        dealer.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        dealer.addCardToHand(new Card(Suit.HEARTS, Rank.NINE));
        assertEquals(20, dealer.calculateHandValue());
    }

    // Test that the calculateHandValue() method correctly calculates the hand value with two aces
    @Test
    public void testCalculateHandValue_twoAces() {
        dealer.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        dealer.addCardToHand(new Card(Suit.HEARTS, Rank.ACE));
        assertEquals(12, dealer.calculateHandValue());
    }

    // Test that the calculateHandValue() method correctly calculates the hand value at the ace boundary
    @Test
    public void testCalculateHandValue_aceBoundary() {
        dealer.addCardToHand(new Card(Suit.CLUBS, Rank.ACE));
        dealer.addCardToHand(new Card(Suit.HEARTS, Rank.TEN));
        dealer.addCardToHand(new Card(Suit.DIAMONDS, Rank.TEN));
        assertEquals(21, dealer.calculateHandValue());
    }
}
