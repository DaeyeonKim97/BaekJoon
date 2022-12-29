package bj6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(bufferedReader.readLine());
        StringBuffer stringBuffer = new StringBuffer();
        while (number-- > 0) {
            addKhayingYearToStringBuffer(stringBuffer);
        }
        System.out.print(stringBuffer);
    }

    private static void addKhayingYearToStringBuffer(StringBuffer stringBuffer) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        stringBuffer.append(getKhayingYear(M, N, x, y)).append('\n');
    }

    private static long getKhayingYear(int M, int N, int x, int y) {
        long lcm = ((long) M * (long) N) / gcd(M, N);
        for (int a = 0; M * a + x - y < lcm; a++){
            if ((M*a+x-y) % N == 0){
                return M*a+x;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
