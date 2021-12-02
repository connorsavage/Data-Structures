/*
*  File name: SimonGame.java
*  Purpose  : Plays the game Simon with the user
*  Author  : Erin Hurlburt and Connor Savage
*  Date    : 2021-11-9
*/

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


public class SimonGame {

    public static void main(String[] args) {
        char playAgain;
        Random generator = new Random();
        Scanner colorGuess = new Scanner(System.in);

        do {
            displayInstructions();
            colorGuess.nextLine(); 
 
            String colorsPrint = "";
            String userGuess;

            do {
               colorsPrint = updateColor(colorsPrint);

                displayColor(colorsPrint);

                makeVanish();

                userGuess = getUsersGuess(colorGuess);


            } while (userGotItRight(userGuess, colorsPrint));

            displayStats(colorsPrint);

            System.out.print("Do you want to play again? y/n ");
            try {
                playAgain = colorGuess.nextLine().toLowerCase().charAt(0);
            } catch (Exception e) {
                playAgain = 'y';
            }

        } while (playAgain != 'n');

    }

    
    
    public static void displayStats(String colorLetter) {
        System.out.println();
        System.out.println("WRONG! You submitted the wrong color. Try again next time!");

    }

    
    public static boolean userGotItRight(String userGuess, String cl) {
        return (userGuess.equals(cl));
    }

    
    public static String getUsersGuess(Scanner guess) {
        System.out.println("What is your guess? ");
        while (!guess.hasNextLine()) {
            System.out.println("What is your guess? ");
            guess.nextLine();
        }
        return "" + guess.nextLine();
    }

    
    public static void makeVanish() {
        for (int i = 0; i <= 300; i++) {
            System.out.println();
        }
    }

    
    public static void displayColor(String colorL) {
        System.out.println("The color is: " + colorL);
        int time = (colorL.length() < 5) ? 1000 : 500;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("ERROR in displayColor() method line 129");
        }
    }

    
    public static String updateColor(String colorList) {

        Random rand = new Random();
        String[] colors = {"R", "Y", "G", "B"};
        int randomInt = rand.nextInt(colors.length);
        return colorList + colors[randomInt];


    }


    public static void displayInstructions() {
        
        System.out.println("This is a game of Simon.");
        System.out.println("I'll flash a color on the screen.");
        System.out.println("The goal of the game is to remember the color.");
        System.out.println("I'll add one digit each time, so the game gets harder!");
        System.out.println("If the color is 5 or more digits, I'll only display it for half a second.");
        System.out.print("Press ENTER to begin "); 
    }
}
