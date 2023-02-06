package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 샘터_18513 {

    private static int N;
    private static int K;
    private static int[] arr;

    private static long answer;

    public static void main(String[] args) throws IOException {
        setBase();

        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            queue.add(arr[i]);
            set.add(arr[i]);
        }

        int dist = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();

                int left = now - 1;
                int right = now + 1;

                if (!set.contains(left)) {
                    queue.add(left);
                    answer += dist;
                    set.add(left);
                    if (--K == 0) {
                        return;
                    }
                }
                if (!set.contains(right)) {
                    queue.add(right);
                    answer += dist;
                    set.add(right);
                    if (--K == 0) {
                        return;
                    }
                }
            }
            dist++;
        }
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
    }
}
