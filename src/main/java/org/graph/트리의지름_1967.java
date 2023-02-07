package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의지름_1967 {

    private static int N;
    private static List<List<Node>> list;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(answer);
    }

    private static void dfs(int num, int sum) {
        for (Node node : list.get(num)) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, sum + node.len);
            }
        }
        answer = Math.max(answer, sum);
    }

    private static class Node {
        int num;
        int len;

        Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to, len));
            list.get(to).add(new Node(from, len));
        }

        answer = 0;
    }
}
