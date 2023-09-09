package org.burte_force;

import java.util.*;

public class 무인도여행 {
    class Solution {
        char[][] map;
        boolean[][] visited;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        class Pos {
            int x;
            int y;

            Pos(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public List<Integer> solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();

            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];

            for (int i=0; i<maps.length; i++) {
                map[i] = maps[i].toCharArray();
            }

            for (int i=0; i<map.length; i++) {
                for(int j=0; j<map[0].length; j++) {
                    if (!visited[i][j] && map[i][j] != 'X') {
                        answer.add(bfs(i, j));
                    }
                }
            }

            if (answer.size() == 0) {
                answer.add(-1);
            } else {
                Collections.sort(answer);
            }

            return answer;
        }

        public int bfs(int x, int y) {
            int sum = 0;

            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(x, y));
            visited[x][y] = true;

            while (!q.isEmpty()) {
                Pos cur = q.poll();

                int cx = cur.x;
                int cy = cur.y;
                sum += map[cx][cy] - '0';

                for (int i=0; i<4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                        continue;
                    }

                    if (!visited[nx][ny] && map[nx][ny] != 'X') {
                        visited[nx][ny] = true;
                        q.add(new Pos(nx, ny));
                    }
                }
            }
            return sum;
        }
    }
}
