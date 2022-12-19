package bj4375;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(getMinDigitCountMultipleWithOnly1(number));
        }
    }

    public static int getMinDigitCountMultipleWithOnly1(int number) {
        int remain = 1;
        int digit = 1;
        while (true) {
            int calcResult = remain % number;
            if (calcResult == 0) {
                return digit;
            }
            remain = calcResult * 10 + 1;
            digit++;
        }
    }
}
