package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기_1654 {

    private static int K;
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K];
        int max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = (Integer.parseInt(br.readLine()));
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        // 2 + 2^32 -1 => OVERFLOW
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            int count = 0;
            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            if (count < N) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }
}
