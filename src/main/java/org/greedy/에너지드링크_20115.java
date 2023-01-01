package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 에너지드링크_20115 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> drinks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static double solve() {
        double result = 0;

        Collections.sort(drinks, Comparator.reverseOrder());

        result += drinks.get(0);
        for (int i = 1; i < N; i++) {
            result += (double) drinks.get(i) / 2;
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        String[] inputs = input.split(" ");

        drinks.clear();
        for (int i = 0; i < N; i++) {
            drinks.add(Integer.parseInt(inputs[i]));
        }
    }
}
