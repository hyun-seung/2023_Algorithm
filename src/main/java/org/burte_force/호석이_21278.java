package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 호석이_21278 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] time;
    private static int INF = 1_000_001;
    private static boolean[] visited;
    private static int[] selected;
    private static int result;
    private static int first;
    private static int second;

    public static void main(String[] args) throws IOException {
        setBase();

        floyd();

        comb(1, 0);

        System.out.println(first + " " + second + " " + result);
    }

    private static void comb(int start, int select) {
        if (select == 2) {
            int sum = 0;
            for (int i = 1; i < N + 1; i++) {
                if(visited[i]) {
                    continue;
                }

                int min = INF;
                for(int s : selected) {
                    min = Math.min(min, time[i][s]);
                }
                sum += min * 2;
            }

            if(result > sum) {
                result = sum;
                first = selected[0];
                second = selected[1];
            }
            return;
        }

        for(int i= start; i<N+1; i++) {
            if(!visited[i]) {
                visited[i] = true;
                selected[select] = i;
                comb(i+1, select+1);
                visited[i] = false;
            }
        }
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (time[i][j] > time[i][k] + time[k][j]) {
                        time[i][j] = time[i][k] + time[k][j];
                    }
                }
            }
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(time[i], INF);
            time[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            time[A][B] = 1;
            time[B][A] = 1;
        }

        visited = new boolean[N + 1];
        selected = new int[2];
        result = INF;
    }
}
