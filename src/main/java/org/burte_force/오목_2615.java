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
        for (int j = 1; j <= SIZE; j++) {
            for (int i = 1; i <= SIZE; i++) {
                if (board[i][j] == BLACK || board[i][j] == WHITE) {
                    for (int k = 0; k < 4; k++) {
                        int x = i;
                        int y = j;
                        int count = 1;

                        while (true) {
                            x += dx[k];
                            y += dy[k];
                            if (x >= 1 && x <= SIZE && y >= 1 && y <= SIZE) {
                                if (board[i][j] == board[x][y]) {
                                    count++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        x = i;
                        y = j;
                        while (true) {
                            x -= dx[k];
                            y -= dy[k];
                            if (x >= 1 && x <= SIZE && y >= 1 && y <= SIZE) {
                                if (board[i][j] == board[x][y]) {
                                    count++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        if (count == 5) {
                            System.out.println(board[i][j]);
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static void setBase() throws IOException {
        board = new int[SIZE + 1][SIZE + 1];
        for (int i = 1; i <= SIZE; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            for (int j = 1; j <= SIZE; j++) {
                board[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }
    }
}
