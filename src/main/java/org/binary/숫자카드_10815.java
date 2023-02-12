package org.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드_10815 {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] answerArr;

    public static void main(String[] args) throws IOException {
        setBase();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (binarySearch(answerArr[i])) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean binarySearch(int target) {
        int left = 0;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = arr[mid];

            if (target < midValue) {
                right = mid - 1;
            } else if (target > midValue) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
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

        M = Integer.parseInt(br.readLine());
        answerArr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            answerArr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
