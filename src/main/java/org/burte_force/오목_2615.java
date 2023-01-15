package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오목_2615 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final int SIZE = 19;
    private static int[][] board;
    private static final int BLACK = 1;
    private static final int WHITE = 2;
    private static int[] dx = {0, 1, 1, -1};
    private static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        setBase();

        solve();
    }

    private static void solve() {
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (board[i][j] == '1' || board[i][j] == '2') {
                    for (int k = 0; k < 4; k++) {
                        int ax = i;
                        int ay = j;
                        int cnt = 1;

                        while (true) {
                            ax += dx[k];
                            ay += dy[k];
                            if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
                                if(board[i][j] == board[ax][ay])cnt ++;
                                else {
                                    break;
                                }
                            } else break;
                        }
                        ax = i;
                        ay = j;

                        while( true) {
                            ax -= dx[k];
                            ay -= dy[k];
                            if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
                                if(board[i][j] == board[ax][ay])cnt ++;
                                else break;

                            } else break;
                        }

                        if (cnt == 5) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            return;
                        }

                    }
                }
            }
        }

        System.out.println(0);
    }

    private static void setBase() throws IOException {
        board = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = Integer.parseInt(inputs[j]);
            }
        }
    }
}
