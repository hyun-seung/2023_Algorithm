package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 숫자고르기_2668 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[] arr;

    private static List<Integer> list;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 1; i < N + 1; i++) {
            isVisited[i] = true;
            dfs(i, i);
            isVisited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer num : list) {
            System.out.println(num);
        }
    }

    private static void dfs(int start, int target) {
        if (!isVisited[arr[start]]) {
            isVisited[arr[start]] = true;
            dfs(arr[start], target);
            isVisited[arr[start]] = false;
        }

        if(arr[start] == target) {
            list.add(target);
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
    }
}
