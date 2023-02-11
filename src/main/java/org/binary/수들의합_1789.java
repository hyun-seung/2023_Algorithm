package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합_1789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());

        long left = 1;
        long right = s;
        long answer = 0;
        long mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if(mid * (mid + 1) / 2 <= s) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
