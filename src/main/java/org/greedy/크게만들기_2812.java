package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 크게만들기_2812 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int K;
    private static String number;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static String solve() {
        int resultLength = N - K;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            if (!stack.empty()) {
                while (!stack.empty() && K > 0 && stack.peek() < number.charAt(i)) {
                    stack.pop();
                    K--;
                }
            }

            stack.push(number.charAt(i));
        }

        while(K > 0){
            K--;
            stack.pop();
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }

        return builder.reverse().toString();
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandK = input.split(" ");
        N = Integer.parseInt(inputNandK[0]);
        K = Integer.parseInt(inputNandK[1]);
        number = reader.readLine();
    }
}
