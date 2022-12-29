package bj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int NOW_CHANNEL = 100;

    public static void main(String[] args) throws IOException {
        // Get user input
        int targetChannel;
        targetChannel = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> brokenNumbers = new HashSet<>();
        int brokenNumberCount = Integer.parseInt(bufferedReader.readLine());

        if (brokenNumberCount > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (brokenNumberCount-- > 0) {
                brokenNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }

        int minCount = Math.abs(NOW_CHANNEL - targetChannel);

        minCount = Math.min(countMoveByUp(targetChannel, brokenNumbers, minCount), minCount);
        minCount = Math.min(countMoveByDown(targetChannel, brokenNumbers, minCount), minCount);

        System.out.println(minCount);
    }

    private static int countMoveByUp(int targetChannel, Set<Integer> brokenNumbers, int minCount) {
        int moveCount = 0;
        int fromChannel = targetChannel;
        while (true) {
            if (moveCount > minCount) {
                return minCount;
            }
            boolean found = true;

            for (int digit : destructDigits(fromChannel)) {
                if (brokenNumbers.contains(digit)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                break;
            }

            moveCount++;
            fromChannel++;
        }

        int digitCount = fromChannel == 0 ? 1 : (int) Math.log10(fromChannel) + 1;
        return moveCount + digitCount;
    }

    private static int countMoveByDown(int targetChannel, Set<Integer> brokenNumbers, int minCount) {
        int moveCount = 0;
        int fromChannel = targetChannel;
        while (true) {
            if (moveCount > minCount || fromChannel < 0) {
                return minCount;
            }
            boolean found = true;

            for (int digit : destructDigits(fromChannel)) {
                if (brokenNumbers.contains(digit)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                break;
            }

            moveCount++;
            fromChannel--;
        }

        int digitCount = fromChannel == 0 ? 1 : (int) Math.log10(fromChannel) + 1;
        return moveCount + digitCount;
    }

    private static List<Integer> destructDigits(int number) {
        List<Integer> result = new ArrayList<>();
        int length = number == 0 ? 1 : (int) Math.log10(number) + 1;
        int remain = number;
        for (int i = length - 1; i >= 0; i--) {
            int baseDigit = (int) Math.pow(10, i);
            result.add(remain / baseDigit);
            remain = remain % baseDigit;
        }
        return result;
    }
}
