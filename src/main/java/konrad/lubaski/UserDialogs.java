package konrad.lubaski;

import java.util.Scanner;

public class UserDialogs {

    public static String readText() {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.length() != 2) {
                System.out.println("Invalid input. Please enter a letter between a-c and number between 1-3");
                continue;
            }
            if ((input.charAt(0) >= 'a' && input.charAt(0) <= 'c' && input.charAt(1) >= '1' && input.charAt(1) <= '3')) {
                return input;
            }
            System.out.println("Invalid input. Please enter a letter between a-c and number between 1-3");
        }
    }

    public static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}