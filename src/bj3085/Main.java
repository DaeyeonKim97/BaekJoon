package bj3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[][] board;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        initBoard();
        System.out.println(getBoardMax());
    }

    private static void initBoard() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        board = new char[N][N];
        for (int i=0; i<N; i++){
            String line = bufferedReader.readLine();
            for (int j=0; j<N; j++){
                board[i][j] = line.charAt(j);
            }
        }
    }

    private static int getBoardMax(){
        int max = 0;
        for (int i = 0; i < N; i ++){
            max = Math.max(getRowMax(i),max);
            max = Math.max(getColumnMax(i),max);
        }

        for (int i = 0; i < N; i ++){
            for (int j =0; j < N-1; j++){
                char originBoard[][] = deepCopy(board);
                swapRowListItem(board, i, j);
                for (int num = 0; num < N; num ++){
                    max = Math.max(getRowMax(num), max);
                    max = Math.max(getColumnMax(num), max);
                }
                board = deepCopy(originBoard);
            }
        }

        for (int i = 0; i < N; i ++){
            for (int j =0; j < N-1; j++){
                char originBoard[][] = deepCopy(board);
                swapColumnListItem(board, i, j);
                for (int num = 0; num < N; num ++){
                    max = Math.max(getRowMax(num), max);
                    max = Math.max(getColumnMax(num), max);
                }
                board = deepCopy(originBoard);
            }
        }


        return max;
    }

    private static char[][] deepCopy(char[][] origin){
        char[][] result = new char[N][N];
        for (int i = 0; i < N; i++){
            result[i] = origin[i].clone();
        }
        return result;
    }

    private static void swapRowListItem(char[][] list, int row ,int index){
        char temp = list[row][index];
        list[row][index] = list[row][index+1];
        list[row][index+1] = temp;
    }

    private static void swapColumnListItem(char[][] list, int column ,int index){
        char temp = list[index][column];
        list[index][column] = list[index+1][column];
        list[index+1][column] = temp;
    }

    private static int getRowMax(int rowNum){
        int max = 0;
        int count = 1;
        char startChar = board[rowNum][0];
        for (int i = 1; i < N; i ++){
            if (startChar == board[rowNum][i]){
                count ++;
            } else {
                max = Math.max(max, count);
                startChar = board[rowNum][i];
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }


    private static int getColumnMax(int colNum){
        int max = 0;
        int count = 1;
        char startChar = board[0][colNum];
        for (int i = 1; i < N; i ++){
            if (startChar == board[i][colNum]){
                count ++;
            } else {
                max = Math.max(max, count);
                startChar = board[i][colNum];
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
