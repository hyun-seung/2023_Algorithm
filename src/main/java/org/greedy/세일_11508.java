package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 세일_11508 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> prices = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        int result = 0;

        Collections.sort(prices, Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0) {
                continue;
            }

            result += prices.get(i - 1);
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        prices.clear();
        for (int i = 0; i < N; i++) {
            prices.add(Integer.parseInt(reader.readLine()));
        }
    }
}
