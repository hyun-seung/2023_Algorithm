package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈_14916 {

    /*
        2원, 5원 으로만 거스름돈
        동전의 개수가 최소가 되도록 거슬러 주어야 한다.
        최소 동전의 개수가 몇 개인지 알려주는 프로그램

        입력 : 첫째 줄에 거스름돈 액수 n (1 <= n <= 100_000)
        출력 : 거스름돈 동전의 최소 개수 , 만약 거슬러 줄 수 없으면 -1 출력
     */

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int N;

    public static void main(String[] args) throws IOException {
        System.out.print(solve());
    }

    public static void setN() throws IOException {
        N = Integer.parseInt(reader.readLine());
    }

    public static int solve() throws IOException {
        setN();

        int result = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                result += N / 5;
                N /= 5;
                break;
            }

            N -= 2;
            result++;
        }

        if (N < 0) {
            return -1;
        }

        return result;
    }
}
