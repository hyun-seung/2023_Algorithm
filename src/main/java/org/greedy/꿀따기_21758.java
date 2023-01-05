package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 꿀따기_21758 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> honeys = new ArrayList<>();

    private static long total;
    private static long[] rightTotal;
    private static long[] leftTotal;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static long solve() {
        long result = 0;

        setTotals();

        long leftHoney = getMaxByLeftHoney();
        long middleHoney = getMaxByMiddleHoney();
        long rightHoney = getMaxByRightHoney();

        result = Math.max(leftHoney, Math.max(middleHoney, rightHoney));

        return result;
    }

    private static void setTotals() {
        setRightTotal();
        setLeftTototal();
        total = rightTotal[N-1];
    }

    private static void setRightTotal() {
        rightTotal = new long[N];

        long temp = 0;

        for (int i = 0; i < N; i++) {
            temp += honeys.get(i);
            rightTotal[i] = temp;
        }
    }

    private static void setLeftTototal() {
        leftTotal = new long[N];

        long temp = 0;

        for (int i = N - 1; i >= 0; i--) {
            temp += honeys.get(i);
            leftTotal[i] = temp;
        }
    }

    private static long getMaxByLeftHoney() {
        long max = 0;
        long bee1;
        long bee2;

        for (int i = N - 2; i >= 1; i--) {
            bee1 = total - honeys.get(N-1) - honeys.get(i);
            bee2 = total - leftTotal[i];
            max = Math.max(max, bee1 + bee2);
        }
        return max;
    }

    private static long getMaxByMiddleHoney() {
        long max = 0;
        long bee1;
        long bee2;

        for (int i = 1; i <= N-2; i++) {
            bee1 = rightTotal[i] - honeys.get(0);
            bee2 = leftTotal[i] - honeys.get(N-1);
            max = Math.max(max, bee1 + bee2);
        }
        return max;
    }

    private static long getMaxByRightHoney() {
        long max = 0;
        long bee1;
        long bee2;

        for (int i = 1; i <= N-2; i++) {
            bee1 = total - honeys.get(0) - honeys.get(i);
            bee2 = total - rightTotal[i];
            max = Math.max(max, bee1 + bee2);
        }
        return max;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        String[] inputHoneys = input.split(" ");
        honeys.clear();
        for (int i = 0; i < N; i++) {
            honeys.add(Integer.parseInt(inputHoneys[i]));
        }
    }
}
