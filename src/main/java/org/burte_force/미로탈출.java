package org.burte_force;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    class Solution {
        char[][] map;
        boolean[][] visited;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        class Pos {
            int x;
            int y;
            int level;

            Pos (int x, int y, int level) {
                this.x = x;
                this.y = y;
                this.level = level;
            }
        }

        public int solution(String[] maps) {
            int answer = 0;

            map = new char[maps.length][maps[0].length()];
            visited = new boolean[map.length][map[0].length];

            Pos start = null;
            Pos lever = null;
            Pos end = null;

            for (int i=0; i<maps.length; i++) {
                for(int j=0; j<maps[0].length(); j++) {
                    char now = maps[i].charAt(j);
                    if (now == 'S') {
                        start = new Pos(i, j, 0);
                    } else if (now == 'L') {
                        lever = new Pos(i, j, 0);
                    } else if (now == 'E') {
                        end = new Pos(i, j, 0);
                    }
                    map[i][j] = now;
                }
            }

            answer = bfs(start, lever, maps);
            if (answer > -1) {
                visited = new boolean[map.length][map[0].length];

                int leverToEnd = bfs(lever, end, maps);
                if (leverToEnd == -1) {
                    return -1;
                } else {
                    answer += leverToEnd;
                }
            }
            return answer;
        }

        int bfs(Pos start, Pos end, String[] maps) {
            Queue<Pos> q = new LinkedList<>();

            q.add(new Pos(start.x, start.y, 0));
            visited[start.x][start.y] = true;

            while (!q.isEmpty()) {
                Pos now = q.poll();
                int x = now.x;
                int y = now.y;
                int level = now.level;

                if (x == end.x && y == end.y) {
                    return level;
                }

                for (int i=0; i<4; i++) {
                    int moveX = x + dx[i];
                    int moveY = y + dy[i];

                    if (moveX < 0 || moveX >= maps.length || moveY < 0 || moveY >= maps[0].length()) {
                        continue;
                    }

                    if (!visited[moveX][moveY] && map[moveX][moveY] != 'X') {
                        q.add(new Pos(moveX, moveY, level + 1));
                        visited[moveX][moveY] = true;
                    }
                }
            }
            return -1;
        }
    }
}
