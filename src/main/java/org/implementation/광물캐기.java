package org.implementation;

import java.util.Arrays;
import java.util.Comparator;

public class 광물캐기 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int N = picks[0] + picks[1] + picks[2];
        int[][] section = new int[(minerals.length / 5) + 1][3];

        for (int i = 0; i < minerals.length && N > 0; i++) {
            String now = minerals[i];

            if (now.equals("diamond")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 5;
                section[i / 5][2] += 25;
            } else if (now.equals("iron")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 5;
            } else if (now.equals("stone")) {
                section[i / 5][0] += 1;
                section[i / 5][1] += 1;
                section[i / 5][2] += 1;
            }
            if (i % 5 == 4) {
                N--;
            }
        }

        Arrays.sort(section, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] < o2[2]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for (int i = 0, pick = 0; i < section.length; i++) {
            while (pick < 3 && picks[pick] == 0) {
                pick++;
            }

            if (pick == 3) {
                break;
            }

            picks[pick]--;
            answer += section[i][pick];
        }

        return answer;
    }
}
