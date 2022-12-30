package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 알바생_강호_1758 {

    /*
        팁 : 원 금액 - (받은 등수 - 1)
        팁이 0원 이하일 경우 팁 X
        팁의 최대값은?
     */

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static List<Integer> tips = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static long solve() {
        Collections.sort(tips, Collections.reverseOrder());

        long result = 0;
        int temp;
        for (int i = 0; i < N; i++) {
             temp = tips.get(i) - i;
             if(temp <= 0) {
                 break;
             }
             result += temp;
        }

        return result;
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());

        tips.clear();
        for (int i = 0; i < N; i++) {
            tips.add(Integer.parseInt(reader.readLine()));
        }
    }
}
