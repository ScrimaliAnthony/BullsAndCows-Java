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
}
