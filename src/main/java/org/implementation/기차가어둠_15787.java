package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 기차가어둠_15787 {

    private static int N;
    private static int M;
    private static boolean[][] train;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        train = new boolean[N + 1][21];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            int seat;

            if (select == 1) {
                seat = Integer.parseInt(st.nextToken());
                train[trainNum][seat] = true;
            } else if (select == 2) {
                seat = Integer.parseInt(st.nextToken());
                train[trainNum][seat] = false;
            } else if (select == 3) {
                for (int j = 20; j >= 2; j--) {
                    train[trainNum][j] = train[trainNum][j - 1];
                }
                train[trainNum][1] = false;
            } else {
                for (int j = 1; j < 20; j++) {
                    train[trainNum][j] = train[trainNum][j + 1];
                }
                train[trainNum][20] = false;
            }
        }

        Set<String> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= 20; j++) {
                if (train[i][j]) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            set.add(sb.toString());
        }

        System.out.println(set.size());
    }
}
