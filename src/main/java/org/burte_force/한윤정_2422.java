package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한윤정_2422 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;   // 아이스크림 종류의 수
    private static int M;   // 섞어먹으면 안 되는 조합의 개수
    private static int[][] map;
    private static int result;


    public static void main(String[] args) throws IOException {
        setBase();

        solve();
        System.out.println(result);
    }

    private static void solve() {
        dfs(1, 0, new int[3]);
    }

    private static void dfs(int iceCream, int index, int pick[]) {
        if (index == 3) {
            if (map[pick[0]][pick[1]] == 1 || map[pick[1]][pick[2]] == 1
                    || map[pick[0]][pick[2]] == 1) {
                return;
            }
            result++;
            return;
        }

        if (iceCream == N + 1) {
            return;
        }

        pick[index] = iceCream;
        dfs(iceCream + 1, index + 1, pick);
        dfs(iceCream + 1, index, pick);
    }

    private static void setBase() throws IOException {
        String input = reader.readLine();
        String[] inputNandM = input.split(" ");
        N = Integer.parseInt(inputNandM[0]);
        M = Integer.parseInt(inputNandM[1]);

        map = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String inputMap = reader.readLine();
            String[] inputMaps = inputMap.split(" ");
            map[Integer.parseInt(inputMaps[0])][Integer.parseInt(inputMaps[1])] = 1;
            map[Integer.parseInt(inputMaps[1])][Integer.parseInt(inputMaps[0])] = 1;
        }
    }
}
