/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shivam
 * @author pravsimran
 */



public class WarPlayer extends Player {

    public WarPlayer(String name) {
        super(name);
    }

    @Override
    public void play() {
     
    }

    public Card playCard() {
        return getGroup().drawCard();
    }
}
