package bullscows;

import java.util.Scanner;

public class Checker {
    public static int bullChecker(char[] arr, char[] secretCode) {
         int numOfBulls = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == secretCode[i]) {
                numOfBulls++;
            }
        }
        return numOfBulls;
    }

    public static int cowChecker(char[] arr, char[] secretCode) {
        int numOfCows = 0;
        for (char c : arr) {
            for (int y = 0; y < arr.length; y++) {
                if (c == secretCode[y]) {
                    numOfCows++;
                    break;
                }
            }
        }
        return numOfCows;
    }

    public void GuessAndCheck(NumberGenerator nb) {
        char[] secretCode = nb.getNumber().toCharArray();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        boolean gameOver = false;
        while (!gameOver) {
            System.out.printf("Turn %d:\n", turn);

            String guess = scanner.nextLine();
            char[] guessArr = guess.toCharArray();
            int numOfAnswers = cowChecker(guessArr, secretCode);
            int numOfBulls = bullChecker(guessArr, secretCode);
            int numOfCows = cowChecker(guessArr, secretCode) - numOfBulls;
            String answer;
            if (numOfAnswers == 0) {
                answer = "None. ";
            } else if (numOfBulls == 0) {
                answer = numOfCows + " cow(s). ";
            } else if (numOfCows == 0) {
                answer = numOfBulls + " bull(s).";
            } else {
                answer = numOfBulls + " bull(s) and " + numOfCows + " cow(s). ";
            }
            System.out.println("Grade: " + answer);
            if (numOfBulls == secretCode.length) {
                gameOver = true;
                System.out.println("Congratulations! You guessed the secret code.");
            }
            turn++;
        }
    }
}
