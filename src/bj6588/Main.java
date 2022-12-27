package bj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer stringBuffer = new StringBuffer();
    private static final int MAX_NUMBER = 1_000_000;
    private static boolean sieveOfEratosthenes[] = new boolean[MAX_NUMBER + 1];

    public static void main(String[] args) throws IOException {
        initSieve();
        int input = Integer.parseInt(bufferedReader.readLine());
        while (input != 0){
            boolean find = false;
            for (int i = input; i >= 3; i--){
                if (sieveOfEratosthenes[i]==false){
                    continue;
                }
                if (sieveOfEratosthenes[input-i]==true){
                    find = true;
                    stringBuffer.append(input).append(" = ").append(input-i).append(" + ").append(i).append("\n");
                    break;
                }
            }
            if (find == false){
                stringBuffer.append("Goldbach's conjecture is wrong.").append("\n");
            }
            input = Integer.parseInt(bufferedReader.readLine());
        }
        System.out.print(stringBuffer);
    }

    private static void initSieve() {
        Arrays.fill(sieveOfEratosthenes, true);
        sieveOfEratosthenes[0] = false;
        sieveOfEratosthenes[1] = false;
        for (int i = 2; i <= MAX_NUMBER; i++) {
            for (int j = 2; i * j <= MAX_NUMBER; j++) {
                sieveOfEratosthenes[i * j] = false;
            }
        }
    }
}
