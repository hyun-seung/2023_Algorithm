package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 주유소_13305 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Long> lengths = new ArrayList<>();
    private static List<Long> prices = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static long solve() {
        long result = 0;

        long min = prices.get(0);
        for(int i=0; i<N-1; i++) {
            if(min > prices.get(i)) {
                min = prices.get(i);
            }

            result += min * lengths.get(i);
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        String lengthInput = reader.readLine();
        String[] lengthInputs = lengthInput.split(" ");

        String priceInput = reader.readLine();
        String[] priceInputs = priceInput.split(" ");

        lengths.clear();
        for(int i=0; i<N-1; i++) {
            lengths.add(Long.parseLong(lengthInputs[i]));
        }

        prices.clear();
        for(int i=0; i<N; i++) {
            prices.add(Long.parseLong(priceInputs[i]));
        }
    }
}
