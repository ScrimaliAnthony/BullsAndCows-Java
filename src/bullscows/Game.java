package bullscows;

import java.util.Scanner;
import java.util.Random;

class Game {

    private char[] secretCode;
    private int lengthOfSecretCode;
    private int numberOfPossibleSymbols;
    private int bulls = 0;
    private int cows = 0;
    private int turn = 1;

    Game(Scanner sc) {
        lengthOfSecretCode(sc);
        numberOfPossibleSymbols(sc);
        secretCode = generateSecretCode(lengthOfSecretCode, numberOfPossibleSymbols);
    }

    private void lengthOfSecretCode(Scanner sc) {
        System.out.println(Display.lengthOfSecretCode());

        if (!sc.hasNextInt()) {
            throw new IllegalArgumentException("Error: the input is not a valid number.");
        }

        int askLengthOfSecretCode = sc.nextInt();
        sc.nextLine();

        if(askLengthOfSecretCode > 36) {
            throw new IllegalArgumentException("Error: can't generate a secret number with a length of " + lengthOfSecretCode + " because there aren't enough unique digits.");
        }
        if(askLengthOfSecretCode <= 0) {
            throw new IllegalArgumentException("Error: the length of the secret code must be greater than 0.");
        }
        lengthOfSecretCode = askLengthOfSecretCode;
    }

    private void numberOfPossibleSymbols(Scanner sc) {
        System.out.println(Display.numberOfPossibleSymbols());

        if (!sc.hasNextInt()) {
            throw new IllegalArgumentException("Error: the input is not a valid number.");
        }

        int askNumberOfPossibleSymbols = sc.nextInt();
        sc.nextLine();

        if(askNumberOfPossibleSymbols < lengthOfSecretCode) {
            throw new IllegalArgumentException("Error: it's not possible to generate a code with a length of " + lengthOfSecretCode + " with " + askNumberOfPossibleSymbols + " unique symbols.");
        }
        if(askNumberOfPossibleSymbols > 36) {
            throw new IllegalArgumentException("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }
        numberOfPossibleSymbols = askNumberOfPossibleSymbols;
    }

    private char[] generateSecretCode(int lengthOfSecretCode, int numberOfPossibleSymbols) {
        Random random = new Random();
        StringBuilder secretCode = new StringBuilder();
        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";

        while(secretCode.length() < lengthOfSecretCode) {
            char randomChar = characters.charAt(random.nextInt(numberOfPossibleSymbols));

            if(!secretCode.toString().contains(String.valueOf(randomChar))) {
                secretCode.append(randomChar);
            }
        }
        return secretCode.toString().toCharArray();
    }

    String getSymbolsRange() {
        String fullRange = "0123456789abcdefghijklmnopqrstuvwxyz";
        if (numberOfPossibleSymbols <= 10) {
            return "(0-" + (numberOfPossibleSymbols - 1) + ")";
        } else {
            char lastChar = fullRange.charAt(numberOfPossibleSymbols - 1);
            return "(0-9, a-" + lastChar + ")";
        }
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

    String toDisplaySecretCode() {
        String toDisplaySecretCode = new String(secretCode);
        return toDisplaySecretCode;
    }

    int getBulls() {
        return bulls;
    }

    void resetBulls() {
        bulls = 0;
    }

    int getCows() {
        return cows;
    }

    void resetCows() {
        cows = 0;
    }

    char[] getSecretCode() {
        return secretCode;
    }

    int getTurn() {
        return turn;
    }

    void setTurn() {
        turn++;
    }

    int getLengthOfSecretCode() {
        return lengthOfSecretCode;
    }

}
