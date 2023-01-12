package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 동전게임_9079 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int T;
    private static int[][] coins;

    private static int[] next;
    private static boolean[] visited;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 0; i < T; i++) {
            setCoin();
            solve();
            System.out.println(result);
        }
    }

    private static void solve() {
        int start = getStartValue();
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean finish = false;

        while (!queue.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>(queue);
            queue.clear();

            while(!temp.isEmpty()) {
                int now = temp.poll();
                if (now == 0 || now == 511) {
                    finish = true;
                    break;
                }

                findNext(now);
                for (int i = 0; i < 8; i++) {
                    if (!visited[next[i]]) {
                        visited[next[i]] = true;
                        queue.add(next[i]);
                    }
                }
            }

            if(finish) {
                return;
            }
            result++;
        }
        if(!finish) {
            result = -1;
        }
    }


    private static void findNext(int start) {
        next[0] = change(start, 8, 7, 6);
        next[1] = change(start, 5, 4, 3);
        next[2] = change(start, 2, 1, 0);

        next[3] = change(start, 8, 5, 2);
        next[4] = change(start, 7, 4, 1);
        next[5] = change(start, 6, 3, 0);

        next[6] = change(start, 8, 4, 0);
        next[7] = change(start, 6, 4, 2);
    }

    private static int change(int value, int move1, int move2, int move3) {
        value = value ^ (1 << move1);
        value = value ^ (1 << move2);
        value = value ^ (1 << move3);
        return value;
    }

    private static int getStartValue() {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result *= 2;
                if (coins[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

    private static void setBase() throws IOException {
        T = Integer.parseInt(reader.readLine());
    }

    private static void setCoin() throws IOException {
        coins = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String input = reader.readLine();
            String[] inputs = input.split(" ");
            for (int j = 0; j < 3; j++) {
                if (inputs[j].equals("H")) {
                    coins[i][j] = 1;
                } else {
                    coins[i][j] = 0;
                }
            }
        }

        next = new int[8];
        visited = new boolean[512];
        result = 0;
    }
}
