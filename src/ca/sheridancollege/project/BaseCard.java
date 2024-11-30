/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author hiten
 * 
 */


public class BaseCard extends Card{
    
    public BaseCard(String suit, String rank) {
        super(suit, rank);
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }
    
}
