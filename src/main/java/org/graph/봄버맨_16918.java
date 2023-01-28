package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 봄버맨_16918 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int R;
    private static int C;
    private static int N;
    ;
    private static char[][] map;
    private static int[][] bomb;

    private static int time;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setBase();

        while (time++ < N) {
            // 설치
            if (time % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            bomb[i][j] = time + 3;
                        }
                    }
                }
            } else {
                // 시간에 맞춰 터뜨림
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (bomb[i][j] == time) {
                            map[i][j] = '.';
                            for (int k = 0; k < 4; k++) {
                                int ni = i + dx[k];
                                int nj = j + dy[k];

                                if (ni >= 0 && nj >= 0 && ni < R && nj < C) {
                                    if (map[ni][nj] == 'O' && bomb[ni][nj] != time) {
                                        map[ni][nj] = '.';
                                        bomb[ni][nj] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<R; i++) {
            System.out.println(map[i]);
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'O') {
                    bomb[i][j] = 3;
                }
            }
        }

        time = 0;
    }
}
