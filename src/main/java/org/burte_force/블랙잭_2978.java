package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 블랙잭_2978 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int M;
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int result = 0;

        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    temp = numbers.get(i) + numbers.get(j) + numbers.get(k);

                    if (temp <= M && temp > result) {
                        result = temp;
                    }
                }
            }
        }

        return result;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandM = input.split(" ");
        N = Integer.parseInt(inputNandM[0]);
        M = Integer.parseInt(inputNandM[1]);

        String inputNumber = reader.readLine();
        String[] inputNumbers = inputNumber.split(" ");
        numbers.clear();
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(inputNumbers[i]));
        }
    }
}
