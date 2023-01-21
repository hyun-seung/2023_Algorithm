package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_18808 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;

    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[row][col];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < col; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            find(sticker);
        }

        System.out.println(result);
    }

    private static void find(int[][] sticker) {
        int row = sticker.length;
        int col = sticker[0].length;

        for (int d = 0; d < 4; d++) {
            if (d != 0) {
                sticker = rotate(sticker, row, col);
            }

            row = sticker.length;
            col = sticker[0].length;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + row > N || j + col > M) {
                        break;
                    }

                    if (putOn(i, j, row, col, sticker)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean putOn(int x, int y, int row, int col, int[][] sticker) {
        for (int i = x; i < x + row; i++) {
            for (int j = y; j < y + col; j++) {
                if (map[i][j] == 1 && sticker[i - x][j - y] == 1) {
                    return false;
                }
            }
        }

        for (int i = x; i < x + row; i++) {
            for (int j = y; j < y + col; j++) {
                if (sticker[i - x][j - y] == 1) {
                    map[i][j] = 1;
                    result++;
                }
            }
        }

        return true;
    }

    private static int[][] rotate(int[][] sticker, int row, int col) {
        int[][] temp = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[j][row-1-i] = sticker[i][j];
            }
        }

        return temp;
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        result = 0;
    }
}
