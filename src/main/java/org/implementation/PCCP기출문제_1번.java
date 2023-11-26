package org.implementation;

public class PCCP기출문제_1번 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;

        int sp = attacks[0][0];
        int ep = attacks[attacks.length-1][0];

        int atkidx = 0;
        int btime = 0;
        int maxHealth = health;

        for (int i=sp; i<ep+1; i++) {
            if (i == attacks[atkidx][0]) {
                health -= attacks[atkidx][1];
                atkidx++;
                btime = 0;

                if (health <= 0) {
                    return -1;
                }
                continue;
            }

            health += bandage[1];
            btime++;

            if (btime == bandage[0]) {
                health += bandage[2];
            }

            if (maxHealth > health) {
                health = maxHealth;
            }
        }

        answer = health;
        return answer;
    }
}
