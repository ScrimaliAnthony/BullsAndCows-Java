package bullscows;

import java.util.Scanner;

class Game {

    private char[] secretCode;
    private int bulls = 0;
    private int cows = 0;

    Game() {
        secretCode = "9305".toCharArray();
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
}
