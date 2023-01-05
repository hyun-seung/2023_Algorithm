package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 우체국_2141 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Town> towns = new ArrayList<>();
    private static long totalPersons = 0;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static long solve() {
        Collections.sort(towns);

        long sum = 0;

        for (Town town : towns) {
            sum += town.persons;
            if (sum >= (totalPersons + 1) / 2) {
                return town.position;
            }
        }

        return towns.size() - 1;
    }

    private static class Town implements Comparable<Town> {
        long position;
        long persons;

        Town(long position, long persons) {
            this.position = position;
            this.persons = persons;
        }

        @Override
        public int compareTo(Town o) {
            if (this.position == o.position) {
                return (int) (this.persons - o.persons);
            }

            return (int) (this.position - o.position);
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        towns.clear();
        totalPersons = 0;
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputTowns = input.split(" ");
            towns.add(new Town(Long.parseLong(inputTowns[0]), Long.parseLong(inputTowns[1])));
            totalPersons += Long.parseLong(inputTowns[1]);
        }
    }
}
