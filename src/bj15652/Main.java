package bj15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer stringBuffer = new StringBuffer();
    private static int memo[];

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        memo = new int[M];

        dfs(N, M, 1, 0);

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

        for (int i = index; i <= N; i++) {
            memo[depth] = i;
            dfs(N, M, i, depth + 1);
        }
    }
}

