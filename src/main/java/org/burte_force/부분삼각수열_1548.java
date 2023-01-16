package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 부분삼각수열_1548 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> numbers;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        solve();
        System.out.println(result);
    }

    private static void solve() {
        Collections.sort(numbers);

        for (int first = 0; first < N - 1; first++) {
            for (int third = N - 1; third >= 0; third--) {
                // second가 없는 경우
                if (first + 1 == third) {
                    break;
                }

                if (numbers.get(first) + numbers.get(first + 1) > numbers.get(third)) {
                    result = Math.max(result, third - first + 1);
                    break;
                }
            }
        }

        if(result == 1 && N >= 2) {
            result = 2;
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        numbers = new ArrayList<>();
        String input = reader.readLine();
        String[] inputs = input.split(" ");
        for (int i = 0; i < N; i++) {
            numbers.add(Integer.parseInt(inputs[i]));
        }

        result = 1;
    }
}
