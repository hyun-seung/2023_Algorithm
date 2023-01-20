package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 괄호추가_16637 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> nums;
    private static List<Character> ops;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, nums.get(0));
        System.out.println(result);
    }

    private static void dfs(int now, int sum) {
        if (now == ops.size()) {
            result = Math.max(result, sum);
            return;
        }

        int first = cal(now, sum, nums.get(now + 1));
        dfs(now + 1, first);

        if (now + 1 < ops.size()) {
            int second = cal(now + 1, nums.get(now + 1), nums.get(now + 2));
            int temp = cal(now, sum, second);
            dfs(now + 2, temp);
        }
    }

    private static int cal(int opIndex, int a, int b) {
        switch (ops.get(opIndex)) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 1;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(br.readLine());

        nums = new ArrayList<>();
        ops = new ArrayList<>();

        String input = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums.add(input.charAt(i) - '0');
            } else {
                ops.add(input.charAt(i));
            }
        }

        result = Integer.MIN_VALUE;
    }
}
