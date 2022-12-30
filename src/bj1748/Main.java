package bj1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(bufferedReader.readLine());
        int digit = (int) (Math.log10(number)) + 1;
        int sum = 0;
        for (int i = 1; i < digit; i ++){
            sum += i * (int) Math.pow(10, i);
            if (i == 1){
                sum -= 1;
                continue;
            }
            sum -= i * (int) Math.pow(10,i-1);
        }

        int remain = number - (int) Math.pow(10, digit -1) + 1;
        sum += remain * digit;
        System.out.println(sum);
    }
}
