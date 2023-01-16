package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2_12919 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String origin;
    private static String target;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(origin, target);
        System.out.println(result);
    }

    private static void dfs(String origin, String target) {
        if (origin.length() == target.length()) {
            if (origin.equals(target)) {
                result = 1;
            }
            return;
        }

        if (target.charAt(0) == 'B') {
            String subString = target.substring(1);
            StringBuilder builder = new StringBuilder(subString);
            String newString = builder.reverse().toString();
            dfs(origin, newString);
        }

        if (target.charAt(target.length() - 1) == 'A') {
            dfs(origin, target.substring(0, target.length() - 1));
        }
    }

    private static void setBase() throws IOException {
        origin = reader.readLine();
        target = reader.readLine();
        result = 0;
    }
}
