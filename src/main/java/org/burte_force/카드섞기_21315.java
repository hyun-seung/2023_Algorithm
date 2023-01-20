package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드섞기_21315 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 0; i <= 9; i++) {
            if (Math.pow(2, i) >= N) {
                break;
            }

            for (int j = 0; j <= 9; j++) {
                if (Math.pow(2, j) >= N) {
                    break;
                }

                Queue<Integer> queue = new LinkedList<>();
                for (int k = N; k >= 1; k--) {
                    queue.add(k);
                }
                dfs(i, queue);
                dfs(j, queue);

                boolean check = true;
                for (int k = N - 1; k >= 0; k--) {
                    if(arr[k] != queue.poll()) {
                        check = false;
                        break;
                    }
                }
                if(check) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    private static void dfs(int x, Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>();
        int num = (int) Math.pow(2, x);

        // 첫 번째 단계
        for (int i = 0; i < num; i++) {
            temp.add(queue.poll());
        }
        while (num > 1) {
            // 2^k-i+1 단계 반복
            num /= 2;
            for (int i = 0; i < num; i++) {
                temp.add(temp.poll());
            }
            for (int i = 0; i < num; i++) {
                queue.add(temp.poll());
            }
        }
        queue.add(temp.poll());
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
