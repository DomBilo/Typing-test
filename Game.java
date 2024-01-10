// Package containing the TypingTestGame application
package TypingTestFinalVer;

// Importing necessary packages
import javax.swing.SwingUtilities;

// Main class that initiates the TypingTestGame
public class Game {
    public static void main(String[] args) {
        // Execute the game on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create an instance of the TypingTestGame and run the game
                TypingTestGame game = new TypingTestGame();
                game.runGame();
            }
        });
    }
}
