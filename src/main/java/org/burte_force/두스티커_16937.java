package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 두스티커_16937 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int H;
    private static int W;
    private static int N;
    private static int[][] stickers;


    public static void main(String[] args) throws IOException {
        setBase();

        System.out.println(solve());
    }

    private static int solve() {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (stickers[i][0] + stickers[j][0] <= H && Math.max(stickers[i][1], stickers[j][1]) <= W ||
                        stickers[i][0] + stickers[j][0] <= W && Math.max(stickers[i][1], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                } else if (stickers[i][0] + stickers[j][1] <= H && Math.max(stickers[i][1], stickers[j][0]) <= W ||
                        stickers[i][0] + stickers[j][1] <= W && Math.max(stickers[i][1], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                } else if (stickers[i][1] + stickers[j][0] <= H && Math.max(stickers[i][0], stickers[j][1]) <= W ||
                        stickers[i][1] + stickers[j][0] <= W && Math.max(stickers[i][0], stickers[j][1]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                } else if (stickers[i][1] + stickers[j][1] <= H && Math.max(stickers[i][0], stickers[j][0]) <= W ||
                        stickers[i][1] + stickers[j][1] <= W && Math.max(stickers[i][0], stickers[j][0]) <= H) {
                    sum = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
                }
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputHandW = input.split(" ");
        H = Integer.parseInt(inputHandW[0]);
        W = Integer.parseInt(inputHandW[1]);
        N = Integer.parseInt(reader.readLine());

        stickers = new int[N][2];
        for (int i = 0; i < N; i++) {
            String inputSticker = reader.readLine();
            String[] inputStickers = inputSticker.split(" ");
            stickers[i][0] = Integer.parseInt(inputStickers[0]);
            stickers[i][1] = Integer.parseInt(inputStickers[1]);
        }
    }
}
