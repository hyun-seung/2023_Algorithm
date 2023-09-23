package org.implementation;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if (n < 0) {
                if (k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k -= 1;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
