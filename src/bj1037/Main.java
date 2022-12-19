package bj1037;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int trueNumberOfDivisors = scanner.nextInt();
        List<Integer> divisorsList = new ArrayList<>(trueNumberOfDivisors);
        for (int i = 0; i < trueNumberOfDivisors; i ++){
            divisorsList.add(i, scanner.nextInt());
        }
        divisorsList.sort(null);
        System.out.println(divisorsList.get(0) * divisorsList.get(trueNumberOfDivisors-1));
    }
}
