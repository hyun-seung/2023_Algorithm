package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ATM_11399 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> watingTimes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    public static long solve() {
        Collections.sort(watingTimes);

        long result = 0;
        int temp = 0;
        for(Integer watingTime : watingTimes) {
            temp += watingTime;
            result += temp;
        }
        return result;
    }

    public static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        String input = reader.readLine();
        String[] times = input.split(" ");

        watingTimes.clear();
        for(int i=0; i<N; i++) {
            watingTimes.add(Integer.parseInt(times[i]));
        }
    }
}
