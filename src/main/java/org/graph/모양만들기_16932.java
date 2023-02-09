package org.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 모양만들기_16932 {
    private static int N;
    private static int M;
    private static int arr[][];
    private static int answer = 0;
    private static boolean visited[][];
    private static boolean sector_visited[];
    private static int sector_arr[][];
    private static int dx[] = {0, 0, 1, -1};
    private static int dy[] = {1, -1, 0, 0};
    private static int dir[];
    static ArrayList<Integer> size_list = new ArrayList<>();
    static ArrayList<Node> one_list = new ArrayList<>(); //1을 담을 장소
    static ArrayList<Node> zero_list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        N = Integer.parseInt(t[0]);
        M = Integer.parseInt(t[1]);

        arr = new int[N][M];
        sector_arr = new int[N][M];

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] tt = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tt[j]);
                if (arr[i][j] == 1) {
                    one_list.add(new Node(i, j));
                } else {
                    zero_list.add(new Node(i, j));
                }
            }
        }
        size_list.add(0);   // 구역은 1번 구역부터 시작하니  인덱스 통일하기 위해서 0번째 size_list에 필요없는 값 넣음

        int sector = 1;
        for (int i = 0; i < one_list.size(); i++) {
            Node a = one_list.get(i);
            if (!visited[a.x][a.y]) {
                sector_bfs(a.x, a.y, sector);
                sector++;
            }
        }

        sector_visited = new boolean[sector + 1];

        for (int i = 0; i < zero_list.size(); i++) {
            Node now = zero_list.get(i);
            dir = new int[4];
            solve(now.x, now.y);
        }
        System.out.println(answer);
    }

    public static void solve(int x, int y) {
        int temp = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny) && arr[nx][ny] == 1) {
                int group_num = sector_arr[nx][ny]; // nx,ny과 몇번 그룹인지 얻어냄
                if (!sector_visited[group_num]) {            // 이 그룹의 첫 방문이라면
                    temp += size_list.get(group_num);      // 이 그룹의 1개수를 더해줌
                    sector_visited[group_num] = true;   // 그리고 이 그룹 방문처리
                }
            }       // 만약 이미 방문한 그룹이라면 중복때문에 갈 필요가 없겠죠? 그래서 위에 과정이 있는겁니다
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isRange(nx, ny)) {
                continue;
            }
            sector_visited[sector_arr[nx][ny]] = false;
        }
        answer = Math.max(answer, temp);
    }

    public static void sector_bfs(int x, int y, int sector) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        sector_arr[x][y] = sector;
        visited[x][y] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    sector_arr[nx][ny] = sector;
                    count++;
                }
            }
        }
        size_list.add(count);
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && y >= 0 && x < N && y < M) {
            return true;
        } else {
            return false;
        }
    }


    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
