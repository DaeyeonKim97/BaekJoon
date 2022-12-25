package bj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static boolean sieveOfEratosthenes[] = new boolean[1_000 + 1];

    public static void main(String[] args) throws IOException {
        int result = 0;
        initSieve();
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (N-- > 0){
            int number = Integer.parseInt(stringTokenizer.nextToken());
            if (sieveOfEratosthenes[number]){
                result ++;
            }
        }
        System.out.println(result);
    }

    public static void initSieve(){
        Arrays.fill(sieveOfEratosthenes, true);
        sieveOfEratosthenes[0] = false;
        sieveOfEratosthenes[1] = false;
        for (int i = 2; i <= 1000; i++){
            for (int j = 2; i*j <= 1000; j++){
                sieveOfEratosthenes[i*j] = false;
            }
        }
    }
}
