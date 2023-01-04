package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 센서_2212 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;
    private static List<Integer> points = new ArrayList<>();
    private static List<Integer> diffs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        int result = 0;

        Collections.sort(points);

        diffs.clear();
        for(int i=0; i<N-1; i++) {
            diffs.add(points.get(i+1) - points.get(i));
        }
        Collections.sort(diffs);

        for(int i=0; i<N-K; i++) {
            result += diffs.get(i);
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());
        K = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        String[] inputPoints = input.split(" ");

        points.clear();
        for (int i = 0; i < N; i++) {
            points.add(Integer.parseInt(inputPoints[i]));
        }
    }
}
