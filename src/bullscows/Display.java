package bullscows;

class Display {

    static String result(int bulls, int cows, char[] secretCodeArray) {
        String secretCode = new String(secretCodeArray);
        if(bulls > 0 && cows > 0) {
            return "Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode + ".";
        } else if(bulls > 0 && cows == 0) {
            return "Grade: " + bulls + " bull(s). The secret code is " + secretCode + ".";
        } else if(bulls == 0 && cows > 0) {
            return "Grade: " + cows + " cow(s). The secret code is " + secretCode + ".";
        } else {
            return "Grade: None. The secret code is " + secretCode + ".";
        }
    }

    static String secretNumber(Game game) {
        game.toDisplaySecretCode();
        return "The random secret number is " + game.toDisplaySecretCode();
    }

    static String lengthOfSecretCode() {
        return "Please, enter the secret code's length:";
    }

    static String gameStart() {
        return "Okay, let's start a game!";
    }

    static String turnNb(Game game) {
        return "Turn" + game.getTurn();
    }

    static String congratulation() {
        return "Congratulations! You guessed the secret code.";
    }

    static String numberOfPossibleSymbols() {
        return "Input the number of possible symbols in the code:";
    }

    static String secretIsPrepared(Game game) {
        StringBuilder builder = new StringBuilder("The secret is prepared: ");
        builder.append("*".repeat(game.getLengthOfSecretCode())).append(" ").append(game.getSymbolsRange());

        return builder.toString();
    }
}
