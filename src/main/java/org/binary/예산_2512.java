package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산_2512 {

    private static int N;
    private static int[] arr;
    private static int money;

    public static void main(String[] args) throws IOException {
        setBase();

        Arrays.sort(arr);

        long left = 0;
        long right = arr[N - 1];
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i : arr) {
                if (i >= mid) {
                    sum += mid;
                } else {
                    sum += i;
                }
            }

            if (sum > money) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

    private static void setBase() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        money = Integer.parseInt(br.readLine());
    }
}
