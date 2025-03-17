package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game;

        try {
            game = new Game(sc);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        System.out.println(Display.secretIsPrepared(game));
        System.out.println(Display.gameStart());

        Player player = new Player();

        while(game.toDisplaySecretCode().length() != game.getBulls()) {
            game.resetBulls();
            game.resetCows();
            System.out.println(Display.turnNb(game));
            player.chooseDigitCode(sc, game);
            System.out.println(Display.result(game.getBulls(), game.getCows(), game.getSecretCode()));
            game.setTurn();
        }

        System.out.println(Display.congratulation());
    }
}
