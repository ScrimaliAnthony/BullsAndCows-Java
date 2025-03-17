package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        Player player = new Player();

        player.chooseDigitCode(sc, game);
        System.out.println(Display.result(game.getBulls(), game.getCows(), game.getSecretCode()));
    }
}
