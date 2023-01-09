package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 큰수_18511 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;
    private static int result;

    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        solve();
        System.out.println(result);
    }

    private static void solve() {
        Collections.sort(numbers, Collections.reverseOrder());
        result = 0;
        dfs(0);
    }

    private static void dfs(int now) {
        if (now > N) {
            return;
        }

        if (now > result) {
            result = now;
        }

        for (int i = 0; i < K; i++) {
            dfs(now * 10 + numbers.get(i));
        }
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandK = input.split(" ");
        N = Integer.parseInt(inputNandK[0]);
        K = Integer.parseInt(inputNandK[1]);

        String inputNumber = reader.readLine();
        String[] inputNumbers = inputNumber.split(" ");
        numbers.clear();
        for (int i = 0; i < K; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
    }
}
