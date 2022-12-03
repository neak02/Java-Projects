/*
 * Interactive game to guess a randomized number
 *
 * @author Nerijus Akelaitis
 * @version 1.01
 */

import javax.swing.*;
import java.util.Random;

public class NumberGuesser {
    public static void startGame() {
        // initializing a random number that will be guessed
        Random rand = new Random();
        int randomizedNumber = rand.nextInt(20);
        int lowerRange = 0;
        int upperRange = 20;
        // for owner to know the number
        System.out.println("Number: " + randomizedNumber);

        // guessing the number
        do {
            String numGuess = JOptionPane.showInputDialog(null,
                    "Guess a number." +
                    "\nRange: " + lowerRange + " - " + upperRange,
                    "NumberGuesser", JOptionPane.INFORMATION_MESSAGE);

            if (numGuess == null) {
                System.exit(0);
            }
            try {
                Integer.parseInt(numGuess);
                if (Integer.parseInt(numGuess) == randomizedNumber) {
                    JOptionPane.showMessageDialog(null,
                            "Correct! The number was " + randomizedNumber,
                            "Yes!", JOptionPane.INFORMATION_MESSAGE);
                    againOrExit();
                    break;
                } else if (Integer.parseInt(numGuess) > randomizedNumber) {
                    upperRange = Integer.parseInt(numGuess);
                    JOptionPane.showMessageDialog(null,
                            "You missed. Try a lower guess." +
                            "\nRange: " + lowerRange + " - " + upperRange,
                            "Correction", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    lowerRange = Integer.parseInt(numGuess);
                    JOptionPane.showMessageDialog(null,
                            "You missed. Try a higher guess." +
                            "\nRange: " + lowerRange + " - " + upperRange,
                            "Correction", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Wrong input. Try again with a number.",
                        "Exception", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (true);
    }

    public static void againOrExit() {
        // play again or exit option
        String[] options = {"Play", "Exit"};
        int response = JOptionPane.showOptionDialog(null,
                "Do you want to play again?",
                "Finish",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);
        if (response == JOptionPane.YES_OPTION) {
            startGame(); // play again
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        startGame(); // start the game
    }
}