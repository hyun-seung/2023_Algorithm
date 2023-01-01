package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 블로그2_20365 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static String input;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        int result = 0;

        int blueCount = getCount("R");
        int redCount = getCount("B");

        if (blueCount >= redCount) {
            result = redCount + 1;
            return result;
        }

        if(redCount > blueCount) {
            result = blueCount + 1;
            return result;
        }

        return result;
    }

    private static int getCount(String opposite) {
        String copy = input;
        StringTokenizer st = new StringTokenizer(copy, opposite);
        List<String> results = new ArrayList<>();
        while(st.hasMoreTokens()) {
            results.add(st.nextToken());
        }
        return results.size();
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        input = reader.readLine();
    }
}
