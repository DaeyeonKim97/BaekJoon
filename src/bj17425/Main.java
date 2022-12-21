package bj17425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int N;
    private static Long memo[] = new Long[1_000_001];

    public static void main(String[] args) throws IOException {
        initMemo();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            sb.append(memo[input]).append("\n");
        }
        System.out.println(sb);
    }

    public static void initMemo(){
        Arrays.fill(memo,0L);
        for (int i = 1; i <= 1_000_000; i++){
            for (int j = 1; i*j <= 1_000_000; j++){
                memo[i*j] += i;
            }
            memo[i] += memo[i-1];
        }
    }
}
