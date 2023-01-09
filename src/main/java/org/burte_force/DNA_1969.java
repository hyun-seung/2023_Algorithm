package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DNA_1969 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int M;
    private static List<String> lines = new ArrayList<>();
    private static Character[] dna = {'A', 'C', 'G', 'T'};

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static String solve() {
        int result = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] count = new int[4];
            for (int j = 0; j < N; j++) {
                char temp = lines.get(j).charAt(i);

                for (int k = 0; k < dna.length; k++) {
                    if (dna[k] == temp) {
                        count[k]++;
                        break;
                    }
                }
            }

            int max = 0;
            char choice = 0;

            for (int k = 0; k < 4; k++) {
                if (count[k] > max) {
                    max = count[k];
                    choice = dna[k];
                }
            }

            builder.append(choice);
            result += N - max;
        }

        return builder.toString() + "\n" + result;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandM = input.split(" ");
        N = Integer.parseInt(inputNandM[0]);
        M = Integer.parseInt(inputNandM[1]);

        lines.clear();
        for (int i = 0; i < N; i++) {
            lines.add(reader.readLine());
        }
    }
}
