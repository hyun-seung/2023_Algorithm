package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹_1325 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static List<List<Integer>> list;
    private static boolean[] visited;
    private static int[] ans;
    private static int count;
    private static int max;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 0;
            bfs(i);
            ans[i] = count;
            max = Math.max(max, count);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            if (ans[i] == max) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int node : list.get(temp)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    count++;
                }
            }
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(b).add(a);
        }

        ans = new int[N + 1];
        max = 0;
    }
}
