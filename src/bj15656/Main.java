package bj15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer stringBuffer = new StringBuffer();
    private static int memo[];
    private static int numbers[];

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        numbers = new int[N];
        memo = new int[M];

        StringTokenizer numberStringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0 ; i < N; i++){
            numbers[i] = Integer.parseInt(numberStringTokenizer.nextToken());
        }
        Arrays.sort(numbers);

        dfs(N, M, 0,0);

        System.out.print(stringBuffer);
    }

    public static void dfs(int N, int M, int index, int depth) {
        if (depth == M) {
            for (int i : memo) {
                stringBuffer.append(i).append(" ");
            }
            stringBuffer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            memo[depth] = numbers[i];
            dfs(N, M, i + 1, depth + 1);
        }
    }
}

