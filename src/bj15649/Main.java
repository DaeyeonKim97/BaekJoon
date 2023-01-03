package bj15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer stringBuffer = new StringBuffer();
    private static int memo[];
    private static boolean visit[];

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        memo = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);

        System.out.print(stringBuffer);
    }

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int i : memo) {
                stringBuffer.append(i).append(" ");
            }
            stringBuffer.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                memo[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
