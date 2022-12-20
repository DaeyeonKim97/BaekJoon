package bj17425;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            long result = getSumOfDivisorsLessThenNumber(number);
            System.out.println(result);
        }
    }

    public static long getSumOfDivisorsLessThenNumber(int number) {
        long result = 0;
        for (int i = 1; i <= number; i++) {
            result += number / i * i;
        }
        return result;
    }
}
