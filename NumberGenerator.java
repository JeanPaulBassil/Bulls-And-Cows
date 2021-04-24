package bullscows;


import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class NumberGenerator {
    String number;


    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void mainCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of your secret Number :");
        if (!scanner.hasNextInt()) {
            System.out.printf("Error: \"%s\" isn't a valid number.", scanner.nextLine());
            System.exit(0);
        }
        int length = scanner.nextInt();
        if (length == 0) {
            System.out.println("Error: You cannot create a code with a length of 0");
            System.exit(0);
        }
        System.out.println("Enter the number of possible symbols in the code : ");
        int possibleChars = scanner.nextInt();
        if (possibleChars > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            System.exit(0);
        }
        if (possibleChars < length) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", length, possibleChars);
            System.exit(0);
        }
        String generatedNum = randomNumGenerator(length, possibleChars);
        System.out.println("Okay, let's start a game!");
        setNumber(generatedNum);
        StringBuilder ss = new StringBuilder();
        ss.append("*".repeat(Math.max(0, length)));
        if (possibleChars <= 10) {
            System.out.printf("The secret is prepared: %s (0-%d) \n", ss.toString(), possibleChars - 1);
        } else {
            System.out.printf("The secret is prepared: %s (0-9, a-%c) \n", ss.toString(), 'a' + possibleChars - 11);
        }

    }


    public String randomNumGenerator(int length, int charsNum) {
        Random r = new Random();
        final Set<Character> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            while (true) {
                char val;
                int num = r.nextInt(charsNum - 1) + 1;
                if (num > 9) {
                    val = (char) ('a' + num - 10);
                } else {
                    val = (char) ('0' + num);
                }
                if (!s.contains(val)) {
                    s.add(val);
                    sb.append(val);
                    break;
                }
            }
        }
        return sb.toString();
    }
}