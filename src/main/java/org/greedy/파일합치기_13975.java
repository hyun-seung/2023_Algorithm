package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 파일합치기_13975 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int T; // 테스트 데이터 수
    private static int K; // 소설을 구성하는 장 수
    private static Queue<Long> files = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        setBase();

        for (int i = 0; i < T; i++) {
            setFiles();
            System.out.println(solve());
        }
    }

    private static long solve() {
        long result = 0;

        while (files.size() > 1) {
            Long first = files.poll();
            Long second = files.poll();

            long sum = first + second;

            result += sum;
            files.offer(sum);
        }

        return result;
    }

    private static void setBase() throws IOException {
        T = Integer.parseInt(reader.readLine());
    }

    private static void setFiles() throws IOException {
        K = Integer.parseInt(reader.readLine());
        files.clear();
        String input = reader.readLine();
        String[] inputFiles = input.split(" ");
        for (int i = 0; i < K; i++) {
            files.offer(Long.parseLong(inputFiles[i]));
        }
    }
}
