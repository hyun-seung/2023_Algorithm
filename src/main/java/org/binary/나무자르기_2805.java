package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기_2805 {

    private static int N;
    private static int M;
    private static int[] arr;

    private static long max;

    public static void main(String[] args) throws IOException {
        setBase();

        long start = 0;
        long end = max;

        while(start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for(int i : arr) {
                if(i > mid) {
                    sum += i - mid;
                }
            }

            if(sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start - 1);
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        max = Long.MIN_VALUE;
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
    }
}
