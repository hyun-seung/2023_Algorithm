package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 로프_2217 {

    /*
        N개의 로프
        병렬 연결하면 로프의 중량을 나눌 수 있다
        k 개의 로프를 사용하여 중량이 w인 물체를 들어올리면 w/k 만큼의 중량
        들어올릴 수 있는 최대 중량은?
     */

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static List<Integer> ropes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();
        System.out.print(solve());
    }

    public static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());
        ropes.clear();
        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(reader.readLine()));
        }
    }

    public static int solve() {
        Collections.sort(ropes);

        int max = 0;
        int temp_max;

        for (int i = 0; i < N; i++) {
            temp_max = ropes.get(i) * (N - i);
            if (temp_max > max) {
                max = temp_max;
            }
        }
        return max;
    }
}
