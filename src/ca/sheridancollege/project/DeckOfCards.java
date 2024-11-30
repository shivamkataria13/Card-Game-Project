/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shivam
 * @author hiten
 */




import java.util.ArrayList;
import java.util.Collections;








public class DeckOfCards {
    
    
    private final ArrayList<Card> cards;

    
    
    
    
    public DeckOfCards() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    
    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
    


    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    

    public ArrayList<Card> getCards() {
        return cards;
    }

    
    
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new BaseCard(suit, rank));
            }
        }
    }
        
        
        
    
}
