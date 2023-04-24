package blackjack;

import java.util.*;

public class Game {
    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Game() {
        player = new Player(100); // Create a new player with an initial balance of 100
        dealer = new Dealer(); // Create a new dealer
        deck = new Deck(); // Create a new deck of cards
    }

    // Starts a new round of the game
    public void playRound(Scanner scanner) {
        startNewGame(); // Start a new round of the game

        String input;
        boolean playerBusted = false;
        while (true) {
            System.out.println("Your hand: " + player.getHand());
            System.out.printf("Your hand value: %d%n", player.calculateHandValue());
            System.out.print("Do you want to hit or stand? (h/s): ");
            input = scanner.next();

            if (input.equalsIgnoreCase("h")) {
                player.hit(deck); // Player takes another card from the deck
                if (player.calculateHandValue() > 21) {
                    playerBusted = true; // Player has busted
                    System.out.println("Your hand: " + player.getHand());
                    System.out.printf("Your hand value: %d%n", player.calculateHandValue());
                    break;
                }
            } else {
                break; // Player chooses to stand
            }
        }

        dealer.revealHiddenCard(); // Reveal the dealer's hidden card
        if (!playerBusted) {
            dealer.playTurn(deck); // Dealer plays their turn according to the rules of Blackjack
        }
        System.out.println("Dealer's hand: " + dealer.getHand());
        System.out.println("Dealer's hand value: " + dealer.calculateHandValue());
        declareWinner(); // Determine the winner of the round
    }

    // Starts a new round of the game by creating a new deck, shuffling it, and dealing cards to the player and dealer
    public void startNewGame() {
        deck = new Deck(); // Create a new deck for every round
        deck.shuffle(); // Shuffle the deck

        player.clearHand(); // Clear the player's hand
        dealer.clearHand(); // Cleat the dealer's hand

        // Deal twwo cards to the player and two cards to the dealer
        Card playerCard1 = deck.dealCard();
        Card playerCard2 = deck.dealCard();
        player.addCardToHand(playerCard1);
        player.addCardToHand(playerCard2);

        Card dealerCard1 = deck.dealCard();
        Card dealerCard2 = deck.dealCard();
        dealer.addCardToHand(dealerCard1);
        dealer.setHiddenCard(dealerCard2); // Set one of the dealer's cards as hidden
    }

    // Determines the winner of the round and updates the player's balance accordingly
    public void declareWinner() {
    int playerHandValue = player.calculateHandValue();
    int dealerHandValue = dealer.calculateHandValue();

    if (playerHandValue > 21) {
        System.out.println("Player busts! Dealer wins.");
    } else if (dealerHandValue > 21) {
        System.out.println("Dealer busts! Player wins.");
        player.updateBalance(player.getBetAmount() * 1.5); // Player wins 1.5 times their bet amount
    } else if (playerHandValue > dealerHandValue) {
        System.out.println("Player wins!");
        player.updateBalance(player.getBetAmount() * 1.5);
    } else if (playerHandValue < dealerHandValue) {
        System.out.println("Dealer wins!");
    } else {
        System.out.println("It's a tie!");
        player.updateBalance(0); // Player gets their bet amount back in case of a tie
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

