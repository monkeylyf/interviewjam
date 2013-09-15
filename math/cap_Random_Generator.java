/*Random_Generator
career_cap

Write a method to generate a random number between 1 and 7, given a method
that generates a random number between 1 and 5 (i e , implement rand7() using
rand5())
*/

import java.util.Random;


public class cap_Random_Generator {

    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i) {
            System.out.println(rand7());
        }
    }

    public static int rand5() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(5) + 1;
    }

    public static int rand7() {
        // The ihead behind this is since we have a uniform distribution of 1 - 5
        // we need uniform distribution of 1 - 7 
        // or 1 - 14
        // or 1 - 21
        // (rand5() - 1) * 5 + rand5() - 1 give us uniform distribution of 0, 24
        // If it hits 21/22/23/24 then loop it over, otherwise yield n % 7.
	    while (true) {
		    int num = rand5() * 5 + rand5() - 6; // U[0, 24]
		    if (num < 21) {
                return num % 7 + 1;
            }
	    }
    }
}
