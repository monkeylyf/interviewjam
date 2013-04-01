import java.util.*;


public class Raquetball {

    /** 
     * @param args
     */
    public static void main(String[] args) {
        int totalTrial = 1000;
        double gameIWon = 0;
        for (int i = 0; i < 1000; ++i) {
            if (winGame()) {
                ++gameIWon;
            }
        }
        System.out.println(gameIWon / totalTrial);
    }
    public static boolean winGame() {
        int[] score = new int[2]; // Int array to record current score.
        return nextRound(score, true);
    }
    
    public static boolean nextRound(int[] score, boolean iServe) {
        if (score[0] == 21) {
            return true; // score[0] represents my current score.
        } else if (score[1] == 21) {
            return false; // score[1] represents my opponent's score.
        } else {
            if (iServe) { // I serve the ball in this round.
                if (generator(6)) { // and I win a volley.
                    ++score[0]; // Update score.
                    return nextRound(score, true); // Next Round I still serve.
                } else {
                    // and I lost a volley. Change serve. Score unchanged.
                    return nextRound(score, false);
                }
            } else { // My opponent serves.
                if (generator(5)) { // and he/she win a volley
                    ++score[1];
                    return nextRound(score, false);
                } else { // I win a volley. Change serve.
                    return nextRound(score, true);
                }
            }
        }
    }
    
    public static boolean generator(int target) {
        // Helper function to yield true/false with required probability.
        return new Random().nextInt(10) <= target;
    }
}
