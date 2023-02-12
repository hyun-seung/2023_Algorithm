package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수제곱근_2417 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long left = 0;
        long right = N;
        long min = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long pow = (long) Math.pow(mid, 2);

            if(pow >= N) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(min);
    }
}
