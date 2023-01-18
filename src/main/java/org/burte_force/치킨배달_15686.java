package org.burte_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달_15686 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[][] map;
    private static List<Point> persons = new ArrayList<>();
    private static List<Point> chickens = new ArrayList<>();
    private static boolean[] open;
    private static int result;

    public static void main(String[] args) throws IOException {
        setBase();

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int count) {
        if (count == M) {
            int answer = 0;

            for (int i = 0; i < persons.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chickens.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(persons.get(i).x - chickens.get(j).x) + Math.abs(
                                persons.get(i).y - chickens.get(j).y);
                        temp = Math.min(temp, distance);
                    }
                }
                answer += temp;
            }
            result = Math.min(result, answer);
            return;
        }

        for(int i=start; i<chickens.size(); i++) {
            open[i] = true;
            dfs(i+1, count+1);
            open[i] = false;
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void setBase() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        persons.clear();
        chickens.clear();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    persons.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        open = new boolean[chickens.size()];
    }
}
