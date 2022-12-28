package bj1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int EARTH_MAX = 15;
    private static final int SUN_MAX = 28;
    private static final int MOON_MAX = 19;

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int earth = Integer.parseInt(stringTokenizer.nextToken()) % EARTH_MAX;
        int sun = Integer.parseInt(stringTokenizer.nextToken()) % SUN_MAX;
        int moon = Integer.parseInt(stringTokenizer.nextToken()) % MOON_MAX;

        int year = 1;

        while (true) {
            if (year % EARTH_MAX == earth && year % SUN_MAX == sun && year % MOON_MAX == moon) {
                System.out.println(year);
                return;
            }
            year++;
        }
    }
}
