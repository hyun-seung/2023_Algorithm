package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 연산_21943 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int[] arr;
    private static int P;
    private static int Q;
    private static int result;

    private static boolean[] visited;
    private static List<Integer> pick;
    private static int[] ops;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int index, int p, int q) {
        if (p <= P && q <= Q) {
            if (index == N) {
                result = Math.max(result, calc());
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick.add(arr[i]);
                if (index == 0) {
                    dfs(index + 1, p, q);
                } else {
                    ops[index] = 1;
                    dfs(index + 1, p + 1, q);

                    ops[index] = 2;
                    dfs(index + 1, p, q + 1);

                    ops[index] = 0;
                }
                pick.remove(index);
                visited[i] = false;
            }
        }
    }

    private static int calc() {
        List<Integer> tempList = new ArrayList<>();
        int temp = pick.get(0);
        for (int i = 1; i < N; i++) {
            if(ops[i] == 1) {
                temp += pick.get(i);
            }
            if(ops[i] == 2) {
                tempList.add(temp);
                temp = pick.get(i);
            }
        }
        tempList.add(temp);
        temp = 1;
        for(int i=0; i<tempList.size(); i++) {
            temp *= tempList.get(i);
        }
        return temp;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        result = 0;

        visited = new boolean[N];
        pick = new ArrayList<>();
        ops = new int[N];
    }
}
