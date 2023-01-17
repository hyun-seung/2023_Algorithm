package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 제곱수찾기_1025 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;   //행(세로)
    private static int M;   //열(가로)
    private static String[] arr;
    private static int[][] map;
    private static int answer;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 0; i < M; i++) {    //가로(열)
            for (int j = 0; j < N; j++) {    //세로(행)
                solve(i, j);
            }
        }

        System.out.println(answer);
    }

    private static void solve(int x, int y) {
        for (int i = -N; i < N; i++) {      //행 공차
            for (int j = -M; j < M; j++) {  //열 공차
                if (i == 0 && j == 0) {
                    continue;
                }

                int nx = x;
                int ny = y;

                int sqr = 0;

                while (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    sqr *= 10;
                    sqr += map[ny][nx];

                    int root = (int)Math.sqrt(sqr);

                    if(Math.pow(root, 2) == sqr) {
                        answer = Math.max(answer, sqr);
                    }

                    nx += j;
                    ny += i;
                }
            }
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = arr[i].charAt(j) - '0';
            }
        }
        answer = -1;
    }
}
