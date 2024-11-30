/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.UUID; 

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author shivam 
 * @author simran
 */


public abstract class Player {
    private String name;
    private GroupOfCards group;
    private final String playerID;

    public Player(String name) {
        this.name = name;
        this.group = new GroupOfCards();
        this.playerID = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupOfCards getGroup() {
        return group;
    }

    public void setGroup(GroupOfCards group) {
        this.group = group;
    }

    public abstract void play();
}