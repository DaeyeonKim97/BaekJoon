package bj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX_NUMBER = 10;
    private static int numberOfSum[] = new int[MAX_NUMBER + 1];

    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        initNumberOfSum();

        int inputCount = Integer.parseInt(bufferedReader.readLine());

        while (inputCount -- > 0){
            int inputNumber = Integer.parseInt(bufferedReader.readLine());
            stringBuffer.append(getNumberOfSum(inputNumber)).append("\n");
        }

        System.out.print(stringBuffer);
    }

    private static void initNumberOfSum(){
        numberOfSum[1] = 1;
        numberOfSum[2] = 2;
        numberOfSum[3] = 4;
    }

    private static int getNumberOfSum(int number){
        if (numberOfSum[number] != 0){
            return numberOfSum[number];
        }
        int result = getNumberOfSum(number-1) + getNumberOfSum(number-2) + getNumberOfSum(number-3);
        numberOfSum[number] = result;
        return result;
    }
}
