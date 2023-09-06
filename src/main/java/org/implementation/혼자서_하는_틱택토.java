package org.implementation;

public class 혼자서_하는_틱택토 {

    char[][] map;

    public int solution(String[] board) {
        int answer = 1;

        map = new char[board.length][board[0].length()];
        int Ocount = 0;
        int Xcount = 0;
        for (int i=0; i<board.length; i++) {
            String s = board[i];
            for (int j=0; j<board[0].length(); j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'O') {
                    Ocount += 1;
                } else if (map[i][j] == 'X') {
                    Xcount += 1;
                }
            }
        }

        if (Xcount > Ocount || Ocount - Xcount > 1) {
            return 0;
        }

        boolean isWinO = isWin('O');
        boolean isWinX = isWin('X');

        if (isWinO && isWinX) {
            return 0;
        } else if (isWinO) {
            if (Ocount == Xcount) {
                return 0;
            }
        } else if (isWinX) {
            if (Ocount > Xcount) {
                return 0;
            }
        }
        return answer;
    }

    public boolean isWin(char c) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][0] == map[i][1] && map[i][1] == map[i][2]) {
                return true;
            } else if (map[0][i] == c && map[0][i] == map[1][i] && map[1][i] == map[2][i]) {
                return true;
            }
        }

        if (map[0][0] == c && map[0][0] == map[1][1] && map[1][1] == map[2][2]) {
            return true;
        } else if (map[0][2] == c && map[0][2] == map[1][1] && map[1][1] == map[2][0]) {
            return true;
        }

        return false;
    }
}
