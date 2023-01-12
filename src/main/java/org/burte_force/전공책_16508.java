package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 전공책_16508 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String T;
    private static int N;
    private static List<Book> books = new ArrayList<>();
    private static int result;
    private static int[] count;
    private static int[] select;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, 0);
        if(result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }

    private static void dfs(int index, int total) {
        if (index == N) {
            if (check()) {
                result = Math.min(result, total);
            }
            return;
        }

        for (int i = 0; i < books.get(index).name.length(); i++) {
            select[books.get(index).name.charAt(i) - 'A']++;
        }
        dfs(index + 1, total + books.get(index).price);

        for (int i = 0; i < books.get(index).name.length(); i++) {
            select[books.get(index).name.charAt(i) - 'A']--;
        }
        dfs(index + 1, total);
    }

    private static boolean check() {
        for (int i = 0; i < 26; i++) {
            if (count[i] > select[i]) {
                return false;
            }
        }
        return true;
    }

    private static class Book {
        int price;
        String name;

        Book(int price, String name) {
            this.price = price;
            this.name = name;
        }
    }

    private static void setBase() throws IOException {
        T = reader.readLine();
        N = Integer.parseInt(reader.readLine());

        result = Integer.MAX_VALUE;
        count = new int[26];
        select = new int[26];

        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'A']++;
        }

        books.clear();
        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            String[] inputBook = input.split(" ");
            books.add(new Book(Integer.parseInt(inputBook[0]), inputBook[1]));
        }
    }
}
