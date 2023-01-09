package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 번데기_15721 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int A;
    private static int T;
    private static int TARGET;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int count = 2;
        int bbun = 0;
        int degi = 0;

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    bbun++;
                } else {
                    degi++;
                }

                if (bbun == T && TARGET == 0) {
                    return (bbun + degi - 1) % A;
                }
                if (degi == T && TARGET == 1) {
                    return (bbun + degi - 1) % A;
                }
            }

            for(int i=0; i<count; i++) {
                bbun++;
                if (bbun == T && TARGET == 0) {
                    return (bbun + degi - 1) % A;
                }
            }
            for(int i=0; i<count; i++) {
                degi++;
                if (degi == T && TARGET == 1) {
                    return (bbun + degi - 1) % A;
                }
            }
            count++;
        }
    }

    private static void setBase() throws IOException {
        A = Integer.parseInt(reader.readLine());
        T = Integer.parseInt(reader.readLine());
        TARGET = Integer.parseInt(reader.readLine());
    }
}
