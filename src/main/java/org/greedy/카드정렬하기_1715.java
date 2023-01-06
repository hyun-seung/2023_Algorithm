package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 카드정렬하기_1715 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static Queue<Long> cards = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static long solve() {
        long result = 0;

        while (cards.size() > 1) {
            Long first = cards.poll();
            Long second = cards.poll();

            Long sum = first + second;
            result += sum;
            cards.offer(sum);
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        cards.clear();
        for (int i = 0; i < N; i++) {
            cards.offer(Long.parseLong(reader.readLine()));
        }
    }
}
