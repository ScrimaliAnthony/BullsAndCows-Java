package bullscows;

import java.util.Scanner;
import java.util.Random;

class Game {

    private char[] secretCode;
    private int bulls = 0;
    private int cows = 0;

    Game(Scanner sc) {
        secretCode = generateSecretCode(lengthOfSecretCode(sc));
    }

    private int lengthOfSecretCode(Scanner sc) {
        int lengthOfSecretCode = sc.nextInt();
        sc.nextLine();

        if(lengthOfSecretCode > 10) {
            throw new IllegalArgumentException("Error: can't generate a secret number with a length of " + lengthOfSecretCode + " because there aren't enough unique digits.");
        } else {
            return lengthOfSecretCode;
        }
    }

    private char[] generateSecretCode(int lengthOfSecretCode) {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();

        while(secretCode.length() < lengthOfSecretCode) {
            int digit = random.nextInt(10);

            if(!secretCode.toString().contains(String.valueOf(digit))) {
                secretCode.append(digit);
            }
        }
        return secretCode.toString().toCharArray();
    }

    void compareCode(char[] digitCode) {
        for(int i = 0; i < secretCode.length; i++) {
            if(secretCode[i] == digitCode[i]) {
                bulls++;
            } else {
                for(int j = 0; j < secretCode.length; j++) {
                    if(secretCode[j] == digitCode[i]) {
                        cows++;
                    }
                }
            }
        }
    }

    int getBulls() {
        return bulls;
    }

    int getCows() {
        return cows;
    }

    char[] getSecretCode() {
        return secretCode;
    }

    String toDisplaySecretCode() {
        String toDisplaySecretCode = new String(secretCode);
        return toDisplaySecretCode;
    }
}
