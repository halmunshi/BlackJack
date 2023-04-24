package blackjack;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

// This JUnit test class tests the Player class's ability to place a bet via the canPlaceBet() method and the placeBet() method
public class BetAmountTest {
    private Player player;

    // Initialize the player object with an initial balance of 100 before each test
    @Before
    public void setUp() {
        player = new Player(100);
    }

    // Test that the canPlaceBet() method returns true for a valid bet amount
    @Test
    public void testCanPlaceBet_validBet() {
        assertTrue(player.canPlaceBet(50));
    }

    // Test that the canPlaceBet() method returns false for an invalid bet amount (greater than player's balance)
    @Test
    public void testCanPlaceBet_invalidBet() {
        assertFalse(player.canPlaceBet(101));
    }

    // Test that the canPlaceBet() method returns false for a bet amount of zero
    @Test
    public void testCanPlaceBet_zeroBet() {
        assertFalse(player.canPlaceBet(0));
    }

    // Test that the canPlaceBet() method returns false for a negative bet amount
    @Test
    public void testCanPlaceBet_negativeBet() {
        assertFalse(player.canPlaceBet(-10));
    }

    // Test that the placeBet() method updates the player's balance correctly for a valid bet amount
    @Test
    public void testPlaceBet_validBet() {
        player.placeBet(50);
        assertEquals(50, player.getBalance(), 0.0);
    }

    // Test that the placeBet() method throws an IllegalArgumentException for an invalid bet amount (greater than player's balance)
    @Test(expected = IllegalArgumentException.class)
    public void testPlaceBet_invalidBet() {
        player.placeBet(101);
    }
}
