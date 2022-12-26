package bj1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer stringBuffer = new StringBuffer();
    private static final int MAX_NUMBER = 1_000_000;
    private static boolean sieveOfEratosthenes[] = new boolean[MAX_NUMBER + 1];

    public static void main(String[] args) throws IOException {
        initSieve();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int formal = Integer.parseInt(stringTokenizer.nextToken());
        int latter = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = formal; i <= latter; i++) {
            if (sieveOfEratosthenes[i] == true) {
                stringBuffer.append(i).append("\n");
            }
        }
        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());

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
