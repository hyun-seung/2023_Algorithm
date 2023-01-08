package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학_19532 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String[] inputAtoF;
    private static final int START = -999;
    private static final int LAST = 999;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static String solve() {
        int A = Integer.parseInt(inputAtoF[0]);
        int B = Integer.parseInt(inputAtoF[1]);
        int C = Integer.parseInt(inputAtoF[2]);
        int D = Integer.parseInt(inputAtoF[3]);
        int E = Integer.parseInt(inputAtoF[4]);
        int F = Integer.parseInt(inputAtoF[5]);

        for (int i = START; i < LAST + 1; i++) {
            for (int j = START; j < LAST + 1; j++) {
                if(A*i + B*j == C && D*i + E*j == F) {
                    return i + " " + j;
                }
            }
        }
        return null;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        inputAtoF = input.split(" ");
    }
}
