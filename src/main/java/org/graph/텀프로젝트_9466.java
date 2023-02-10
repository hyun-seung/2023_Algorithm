package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 텀프로젝트_9466 {

    private static int T;
    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] finished;
    private static int count;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            setBase();

            for (int j = 1; j <= N; j++) {
                dfs(j);
            }

            System.out.println(N - count);
        }
    }

    private static void dfs(int now) {
        if (visited[now]) {
            return;
        }

        visited[now] = true;
        int next = arr[now];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                count++;
                for(int i=next; i != now; i=arr[i]) {
                    count++;
                }
            }
        }

        finished[now] = true;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        count = 0;
    }
}
