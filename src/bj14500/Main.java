package bj14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] board;
    private static int row;
    private static int column;
    private static int rotateCount = 0;
    private static boolean symmetry = false;

    public static void main(String[] args) throws IOException {
        initBoard();
        int max = 0;

        for (int i = 0; i < 4; i ++){
            max = Math.max(findMaxSumOfTetromino(), max);
            rotateBoard();
        }

        symmetryBoard();

        for (int i = 0; i < 4; i ++){
            max = Math.max(findMaxSumOfTetromino(), max);
            rotateBoard();
        }
        System.out.println(max);
    }

    private static void initBoard() throws IOException {
        StringTokenizer rowAndColumnStringToken = new StringTokenizer(bufferedReader.readLine());
        row = Integer.parseInt(rowAndColumnStringToken.nextToken());
        column = Integer.parseInt(rowAndColumnStringToken.nextToken());
        board = new int[row][column];

        for (int i = 0; i < row; i++){
            StringTokenizer rowStringToken = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column; j++){
                board[i][j] = Integer.parseInt(rowStringToken.nextToken());
            }
        }
    }

    private static int findMaxSumOfTetromino(){
        int max = 0;
        int sum = 0;

        // 대칭인 테트로미노 카운트
        if (!symmetry){
            // 회전 시 모양이 2개인 테트로미노 카운트 ( ---- )
            if (rotateCount < 2){
                for (int i = 0 ; i < row; i ++){
                    for (int j = 0; j < column-3; j++){
                        sum += board[i][j];
                        sum += board[i][j+1];
                        sum += board[i][j+2];
                        sum += board[i][j+3];
                        max = Math.max(max, sum);
                        sum = 0;
                    }
                }
            }
            // 회전 시 모양이 똑같은 테트로미노 카운트
            if (rotateCount == 0){
                for (int i = 0; i < row-1; i ++){
                    for (int j = 0; j < column-1; j++){
                        sum += board[i][j];
                        sum += board[i][j+1];
                        sum += board[i+1][j];
                        sum += board[i+1][j+1];
                        max = Math.max(max, sum);
                        sum = 0;
                    }
                }
            }
        }

        for (int i = 0; i < row-2; i ++){
            for (int j = 0; j < column-1; j++){
                sum += board[i][j];
                sum += board[i+1][j];
                sum += board[i+2][j];
                sum += board[i+2][j+1];
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        if (rotateCount < 2) {
            for (int i = 0; i < row - 2; i++) {
                for (int j = 0; j < column - 1; j++) {
                    sum += board[i][j];
                    sum += board[i + 1][j];
                    sum += board[i + 1][j + 1];
                    sum += board[i + 2][j + 1];
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
        }

        for (int i = 0; i < row-1; i ++){
            for (int j = 0; j < column-3; j++){
                sum += board[i][j];
                sum += board[i][j+1];
                sum += board[i][j+2];
                sum += board[i+1][j+1];
                max = Math.max(max, sum);
                sum = 0;
            }
        }

        return max;
    }


    private static void rotateBoard() {
        int rotatedBoard[][] = new int[column][row];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                rotatedBoard[j][row -1 -i] = board[i][j];
            }
        }
        int temp = row;
        row = column;
        column = temp;
        board = rotatedBoard;
        rotateCount = (rotateCount + 1) % 4;
    }

    private static void symmetryBoard(){
        int symmetryBoard[][] = new int[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                symmetryBoard[i][column-1-j] = board[i][j];
            }
        }
        board = symmetryBoard;

        symmetry = !symmetry;
    }
}
