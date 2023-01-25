package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기_11725 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int node : tree.get(temp)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parent[node] = temp;
                }
            }
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        visited = new boolean[N + 1];
        parent = new int[N + 1];
    }
}
