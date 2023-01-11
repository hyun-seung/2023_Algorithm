package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 숫자야구_2503 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static List<Data> datas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int result = 0;

        for (int i = 123; i <= 987; i++) {
            if (hasSameOrZero(i)) {
                continue;
            }

            int pass = 0;
            for (Data data : datas) {
                String number = data.number;
                String target = String.valueOf(i);

                int strike = countStrike(number, target);
                int ball = countBall(number, target);

                if (strike == data.strike && ball == data.ball) {
                    pass++;
                }
            }

            if (pass == datas.size()) {
                result++;
            }
        }

        return result;
    }

    private static int countStrike(String number, String target) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    private static int countBall(String number, String target) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (number.charAt(i) == target.charAt((i + 1) % 3) || number.charAt(i) == target.charAt((i + 2) % 3)) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasSameOrZero(int target) {
        String number = String.valueOf(target);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < number.length(); i++) {
            set.add(number.charAt(i));
        }

        if (set.size() != 3) {
            return true;
        }
        if (set.contains('0')) {
            return true;
        }
        return false;
    }

    static class Data {
        String number;
        int strike;
        int ball;

        Data(String number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        datas.clear();
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputData = input.split(" ");
            datas.add(new Data(inputData[0], Integer.parseInt(inputData[1]),
                    Integer.parseInt(inputData[2])));
        }
    }
}
