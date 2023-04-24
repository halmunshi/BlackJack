package blackjack;

/**
 * @author Hasan Al-Munshi
 */
public class Player extends Participant {
    private double balance;
    private double betAmount; // Add the betAmount attribute

    public Player(double initialBalance) {
        super();
        balance = initialBalance;
    }

    public void placeBet(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Bet amount exceeds available balance");
        }
        balance -= amount;
        betAmount = amount; // Update betAmount when placing a bet
    }

    public void updateBalance(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void hit(Deck deck) {
        addCardToHand(deck.dealCard());
    }

    public void stand() {
        // No action needed in this simplified version of the game
    }

    // Add the getBetAmount() method
    public double getBetAmount() {
        return betAmount;
    }
    
    public boolean canPlaceBet(double betAmount) {
        return betAmount > 0 && betAmount <= balance;
    }
}
