/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shivam
 * @author prav simran
 * @author simran
 * @author hiten
 */




import java.util.List;


public class PlayWar extends Game {
    private final int maxRounds;
    private int currentRound;
    private WarPlayer player1;
    private WarPlayer player2;

    
    
    
    
    
    public PlayWar(String player1Name, String player2Name, int maxRounds) {
        super("War");
        this.maxRounds = maxRounds;
        this.currentRound = 0;
        player1 = new WarPlayer(player1Name);
        player2 = new WarPlayer(player2Name);
        List<Player> players = List.of(player1, player2);
        setPlayers(players);
    }
    
    
    
    
    
    
//runs the whole game, each rounds is resolved by executing the executeRound() function
    @Override
    public void play() {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        distributeCards(deck);

        while (currentRound < maxRounds && !player1.getGroup().isEmpty() && !player2.getGroup().isEmpty()) {
            executeRound();
            currentRound++;
        }
    }
    
    
    
    
    
    
    
//distributes the cards making a deck
    private void distributeCards(DeckOfCards deckOfCards) {
        while (!deckOfCards.getCards().isEmpty()) {
            player1.getGroup().addCard(deckOfCards.drawCard());
            if (!deckOfCards.getCards().isEmpty()) {
                player2.getGroup().addCard(deckOfCards.drawCard());
            }
        }
    }

    
    
    
    
    
    
    
    
//    starts a single round of the game, and  if the cards are tied, a "war" is triggered by calling initiateWar().
   private void executeRound() {
       
       
        Card card1 = player1.playCard();
        Card card2 = player2.playCard();

        System.out.println("Round " + (currentRound + 1) + ":");
        System.out.println(player1.getName() + " plays " + card1);
        System.out.println(player2.getName() + " plays " + card2);

        int comparison = compareCards(card1, card2);
        if (comparison > 0) {
            System.out.println(player1.getName() + " wins the round!");
            player1.getGroup().addCard(card1);
            player1.getGroup().addCard(card2);
        } else if (comparison < 0) {
            System.out.println(player2.getName() + " wins the round!");
            player2.getGroup().addCard(card1);
            player2.getGroup().addCard(card2);
        } else {
            System.out.println("It's a tie! War begins...");         
            initiateWar();
        }
        
        
    }

    
    
    
    
//    compares the cards based on the ranks
    private int compareCards(Card card1, Card card2) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int rank1 = java.util.Arrays.asList(ranks).indexOf(card1.getRank());
        int rank2 = java.util.Arrays.asList(ranks).indexOf(card2.getRank());
        return Integer.compare(rank1, rank2);
    }
    
    
    
    
//    Handles the situation when two cards are tied during a round. Each player plays three cards face down and one card face up. The face-up cards are compared, and the war's winner takes all played cards. If players lack sufficient cards for a war, the war is skipped. Calls the processResult() function at the end. 
    private void initiateWar() {
        if (player1.getGroup().getCards().size() < 4 || player2.getGroup().getCards().size() < 4) {
            System.out.println("Insufficient cards for war.");
            return;
        }

        Card[] player1FaceDown = new Card[3];
        Card[] player2FaceDown = new Card[3];

        for (int i = 0; i < 3; i++) {
            player1FaceDown[i] = player1.playCard();
            player2FaceDown[i] = player2.playCard();
        }

        Card player1FaceUp = player1.playCard();
        Card player2FaceUp = player2.playCard();

        System.out.println("War! " + player1.getName() + " plays " + player1FaceUp + " face up.");
        System.out.println("War! " + player2.getName() + " plays " + player2FaceUp + " face up.");

        int warResult = compareCards(player1FaceUp, player2FaceUp);
        processResult(warResult, player1FaceDown, player2FaceDown, player1FaceUp, player2FaceUp);
    }
    
    
    
    
    
    
    
// Comes after the initiateWar() function, and resolves the outcome of the war. Depending on the result of the face-up card comparison, the winning player collects all the face-down and face-up cards. If the result is a tie, the cards are not claimed by either player.
    private void processResult(int result, Card[] cards1, Card[] cards2, Card faceUp1, Card faceUp2) {
        if (result > 0) {
            System.out.println(player1.getName() + " wins the war!");
            player1.getGroup().addCard(faceUp1);
            player1.getGroup().addCard(faceUp2);
            for (int i = 0; i < cards1.length; i++) {
                player1.getGroup().addCard(cards1[i]);
                player1.getGroup().addCard(cards2[i]);
            }
        } else if (result < 0) {
            System.out.println(player2.getName() + " wins the war!");
            player2.getGroup().addCard(faceUp1);
            player2.getGroup().addCard(faceUp2);
            for (int i = 0; i < cards1.length; i++) {
                player2.getGroup().addCard(cards1[i]);
                player2.getGroup().addCard(cards2[i]);
            }
        } else {
            System.out.println("The war ends in a tie!");
        }
    }
    
    
    
    


    
    
    
    
    
    
//    processes the result of the whole game and declares winner. Compares the size of the players' card groups if the maximum rounds are completed or announces the winner if one player runs out of cards. Declares a tie if no clear winner emerges.
    @Override
    public void declareWinner() {
        
        
        if (player1.getGroup().isEmpty() || player2.getGroup().isEmpty()) {
            if (player1.getGroup().isEmpty()) {
                System.out.println(player2.getName() + " wins the game!");
            } else {
                System.out.println(player1.getName() + " wins the game!");
            }

        } else if (currentRound >= maxRounds) {
            int size1 = player1.getGroup().getCards().size();
            int size2 = player2.getGroup().getCards().size();

            if (size1 > size2) {
                System.out.println(player1.getName() + " wins the game!");
            } else if (size1 < size2) {
                System.out.println(player2.getName() + " wins the game!");
            } else {
                System.out.println("It's a tie!");
            }
        }
        
        
    }
}
    
    
    
    
    
    

    

