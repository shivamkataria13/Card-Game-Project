/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author shivam
 * @author simran
 */

import java.util.Scanner;


public class Start {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Player 1: ");
        String player1 = scanner.nextLine();

        System.out.print("Player 2: ");
        String player2 = scanner.nextLine();

        int maxRounds = 10; 
        PlayWar warGameInstance = new PlayWar(player1, player2, maxRounds);
        warGameInstance.play();
        warGameInstance.declareWinner();

        scanner.close();
    }
    
}
