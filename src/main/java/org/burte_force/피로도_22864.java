package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피로도_22864 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int A;   // 증가 피로도
    private static int B;   // 일 처리 가능량
    private static int C;   // 감소 피로도
    private static int M;   // 최대 피로도

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int result = 0;
        int hour = 0;
        int now = 0;

        while (hour < 24) {
            if (now + A > M) {
                now -= C;
                if (now < 0) {
                    now = 0;
                }
            } else {
                now += A;
                result += B;
            }

            hour++;
        }

        return result;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputs = input.split(" ");

        A = Integer.parseInt(inputs[0]);
        B = Integer.parseInt(inputs[1]);
        C = Integer.parseInt(inputs[2]);
        M = Integer.parseInt(inputs[3]);
    }
}
