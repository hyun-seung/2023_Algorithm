package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기_17276 {

    private static int[][] arr;
    private static int[][] temp;
    private static int N;
    private static int D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            temp = new int[N][N];

            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    temp[j][k] = arr[j][k];
                }
            }

            if (D < 0) {
                D += 360;
            }
            D /= 45;

            while(D-- > 0) {
                rotate();
            }

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    sb.append(arr[j][k] + " ");
                }
                if(j != N-1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void rotate() {
        for (int i = 0; i < N; i++) {
            // 1 = 주 대각선을 가운데 열로 이동
            temp[i][N/2] = arr[i][i];
            // 2 = 가운데 열을 부 대각선으로 이동
            temp[i][N-1-i] = arr[i][N/2];
            // 3 = 부 대각선을 가운데 행으로 이동
            temp[N/2][N-1-i] = arr[i][N-1-i];
            // 4 = 가운데 행을 주 대각선으로 이동
            temp[i][i] = arr[N/2][i];
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}
