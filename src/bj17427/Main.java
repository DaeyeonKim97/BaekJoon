package bj17427;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int N;

    public static void main(String[] args) {
        N = scanner.nextInt();
        System.out.println(getSumOfDivisorsLessThenNumber(N));
    }

    public static long getSumOfDivisorsLessThenNumber(int number){
        long result = 0;
        for (int i = 1; i <= number; i ++){
            result += number / i * i;
        }
        return result;
    }
}
