package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 택배_8980 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N; // 마을 수
    private static int C; // 트럭의 용량
    private static int M; // 박스의 개수
    private static Box[] boxes;

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static class Box implements Comparable<Box> {
        int start;
        int end;
        int weight;

        Box(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Box o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }

    private static int solve() {
        Arrays.sort(boxes, 1, M + 1);

        int[] weight = new int[N + 1];
        for (int i = 1; i < N; i++) {
            weight[i] = C;
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            Box box = boxes[i];

            int max = Integer.MAX_VALUE;    // 이동 가능한 최대 한도
            for (int j = box.start; j < box.end; j++) {
                max = Math.min(max, weight[j]);
            }

            if (max >= box.weight) {
                for (int j = box.start; j < box.end; j++) {
                    weight[j] -= box.weight;
                }
                result += box.weight;
            }
            if (max < box.weight) {
                for (int j = box.start; j < box.end; j++) {
                    weight[j] -= max;
                }
                result += max;
            }
        }

        return result;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandC = input.split(" ");
        N = Integer.parseInt(inputNandC[0]);
        C = Integer.parseInt(inputNandC[1]);
        M = Integer.parseInt(reader.readLine());

        boxes = new Box[M + 1];
        for (int i = 1; i <= M; i++) {
            String inputBox = reader.readLine();
            String[] inputBoxInfo = inputBox.split(" ");
            boxes[i] = new Box(Integer.parseInt(inputBoxInfo[0]), Integer.parseInt(inputBoxInfo[1]),
                    Integer.parseInt(inputBoxInfo[2]));
        }
    }
}
