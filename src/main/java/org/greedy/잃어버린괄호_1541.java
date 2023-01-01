package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 잃어버린괄호_1541 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String input;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        String[] minus = input.split("-");

        int result = getSum(minus[0]);
        for(int i=1; i< minus.length; i++) {
            result -= getSum(minus[i]);
        }
        return result;
    }

    private static int getSum(String target) {
        // +, *, ^ 같은 경우 정상작동 위해서는 \\ 추가 해야됨(errorMessage : Dangling ~)
        String[] plus = target.split("\\+");

        int sum = 0;
        for(int i=0; i<plus.length; i++) {
            sum += Integer.parseInt(plus[i]);
        }

        return sum;
    }

    private static void setBase() throws IOException {
        input = reader.readLine();
    }
}
