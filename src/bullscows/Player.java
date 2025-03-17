package bullscows;

import java.util.Scanner;

public class Player {

    private char[] digitCode;

    void chooseDigitCode(Scanner sc, Game game) {
        digitCode = sc.nextLine().toCharArray();
        game.compareCode(getDigitCode());
    }

    char[] getDigitCode() {
        return digitCode;
    }
}
