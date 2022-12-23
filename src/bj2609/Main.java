package bj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int former = Integer.parseInt(st.nextToken());
        int latter = Integer.parseInt(st.nextToken());

        int bigger = Math.max(former, latter);
        int smaller = Math.min(former, latter);

        int greatestCommonDivisor = euclideanAlgorithm(bigger, smaller);
        int leastCommonMultiple = bigger * smaller / greatestCommonDivisor;
        sb.append(greatestCommonDivisor).append("\n");
        sb.append(leastCommonMultiple).append("\n");

        System.out.println(sb);
    }

    private static int euclideanAlgorithm(int a, int b) {
        int remainder = a % b;
        if (remainder == 0) {
            return b;
        }
        return euclideanAlgorithm(b, remainder);

    }
}
