package bj2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> guessList = new ArrayList<>();
    private static List<Integer> tallList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            guessList.add(Integer.parseInt(bufferedReader.readLine()));
        }

        makeTallList:
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j<9; j++){
                for (int number = 0; number < 9; number ++){
                    if (number == i || number == j){
                        continue;
                    }
                    tallList.add(guessList.get(number));
                }
                int sum = tallList.stream().mapToInt(Integer::intValue).sum();
                if (sum == 100){
                    tallList.sort(null);
                    break makeTallList;
                } else {
                    tallList = new ArrayList<>();
                }
            }
        }

        for (int i : tallList){
            System.out.println(i);
        }
    }
}
