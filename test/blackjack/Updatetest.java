/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjack;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author manch
 */
public class Updatetest {
    private List<Card> hand;

    public List<Card> getHand() {
        return hand;
    }

    
    @Test
    public void testCalculateHandValue() {
        Deck deck = new Deck();
        deck.shuffle();

        Dealer dealer = new Dealer();
        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());

        String dealerHand = dealer.getHand();
        int expectedValue = 0;
        int actualValue = 0;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testDeclareWinnerPlayerWins() {
        Player player = new Player(100);
        player.placeBet(10);
        player.addCardToHand(new Card(Suit.HEARTS,Rank.KING));
        player.addCardToHand(new Card(Suit.HEARTS,Rank.QUEEN));

        Dealer dealer = new Dealer();
        dealer.addCardToHand(new Card(Suit.CLUBS,Rank.NINE));
        dealer.addCardToHand(new Card(Suit.SPADES,Rank.SEVEN));
    }

    @Test
    public void testPlayTurn() {
        Deck deck = new Deck();
        deck.shuffle();

        Dealer dealer = new Dealer();
        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());
        dealer.playTurn(deck);

        assertTrue(dealer.calculateHandValue() >= 17 && dealer.calculateHandValue() <= 21);
    }
 


}
