package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ABCDE_13023 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static List<List<Integer>> list;

    private static boolean[] isVisited;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(i, 1);
            if(check) {
                break;
            }
            isVisited[i] = false;
        }

        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int start, int count) {
        if (count == 5) {
            check = true;
            return;
        }

        for (int i : list.get(start)) {
            if (!isVisited[i]) {
                isVisited[start] = true;
                dfs(i, count + 1);
                isVisited[start] = false;
            }

            if (check) {
                return;
            }
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        isVisited = new boolean[N];
        check = false;
    }
}
