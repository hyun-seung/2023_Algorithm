package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IF문_19637 {

    private static int N;
    private static int M;
    private static List<Type> list;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        setBase();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            String str = BinarySearch(target);
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String BinarySearch(int target) {
        int start = 0;
        int end = list.size() - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target > list.get(mid).power) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.get(end + 1).name;
    }

    private static class Type {
        String name;
        int power;

        Type(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }

    private static void setBase() throws IOException {
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            list.add(new Type(name, power));
        }
    }
}
