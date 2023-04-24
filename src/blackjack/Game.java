package blackjack;

import java.util.*;

public class Game {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Game() {
        player = new Player(100);
        dealer = new Dealer();
        deck = new Deck();
    }

    public void playRound(Scanner scanner) {
    startNewGame();

    String input;
    boolean playerBusted = false;
    while (true) {
        System.out.println("Your hand: " + player.getHand());
        System.out.printf("Your hand value: %d%n", player.calculateHandValue());
        System.out.print("Do you want to hit or stand? (h/s): ");
        input = scanner.next();

        if (input.equalsIgnoreCase("h")) {
            player.hit(deck);
            if (player.calculateHandValue() > 21) {
                playerBusted = true;
                System.out.println("Your hand: " + player.getHand());
                System.out.printf("Your hand value: %d%n", player.calculateHandValue());
                break;
            }
        } else {
            break;
        }
    }

    dealer.revealHiddenCard();
    if (!playerBusted) {
        dealer.playTurn(deck);
    }
    System.out.println("Dealer's hand: " + dealer.getHand());
    System.out.println("Dealer's hand value: " + dealer.calculateHandValue());
    declareWinner();
}


    public void startNewGame() {
        deck = new Deck(); // Create a new deck for every round
        deck.shuffle();

        player.clearHand();
        dealer.clearHand();

        Card playerCard1 = deck.dealCard();
        Card playerCard2 = deck.dealCard();
        player.addCardToHand(playerCard1);
        player.addCardToHand(playerCard2);

        Card dealerCard1 = deck.dealCard();
        Card dealerCard2 = deck.dealCard();
        dealer.addCardToHand(dealerCard1);
        dealer.setHiddenCard(dealerCard2);
    }

    public void declareWinner() {
    int playerHandValue = player.calculateHandValue();
    int dealerHandValue = dealer.calculateHandValue();

    if (playerHandValue > 21) {
        System.out.println("Player busts! Dealer wins.");
    } else if (dealerHandValue > 21) {
        System.out.println("Dealer busts! Player wins.");
        player.updateBalance(player.getBetAmount() * 1.5);
    } else if (playerHandValue > dealerHandValue) {
        System.out.println("Player wins!");
        player.updateBalance(player.getBetAmount() * 1.5);
    } else if (playerHandValue < dealerHandValue) {
        System.out.println("Dealer wins!");
    } else {
        System.out.println("It's a tie!");
        player.updateBalance(0);
    }
}


    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Welcome to Blackjack!");

        do {
            System.out.printf("Your current balance: $%.2f%n", game.getPlayer().getBalance());
            System.out.print("Enter your bet amount: ");
            double betAmount = scanner.nextDouble();

            // Check if the bet amount is greater than the player's balance
            while (betAmount > game.getPlayer().getBalance()) {
                System.out.println("You don't have enough balance for this bet. Please enter a valid bet amount.");
                System.out.print("Enter your bet amount: ");
                betAmount = scanner.nextDouble();
            }

            game.getPlayer().placeBet(betAmount);

            game.playRound(scanner);

            System.out.print("Do you want to play another round? (y/n): ");
            input = scanner.next();
        } while (input.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing!");
        scanner.close();
    }



    public void updateBalance() {
        // This method is no longer needed, as we update the player's balance directly in the declareWinner() method.
    }

    public void handleAces() {
        // This method is no longer needed, as we handle the Ace value calculation within the calculateHandValue() method in the Participant class.
    }
}

