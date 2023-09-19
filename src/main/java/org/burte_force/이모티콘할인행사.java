package org.burte_force;

public class 이모티콘할인행사 {
    class Solution {
        int[] discount = {10, 20, 30, 40};
        int maxSub;
        int maxCost;

        public int[] solution(int[][] users, int[] emoticons) {
            maxSub = 0;
            maxCost = 0;

            find(0, new int[emoticons.length], users, emoticons);
            return new int[] {maxSub, maxCost};
        }

        public void find(int index, int[] discounts, int[][] users, int[] emoticons) {
            int elen = emoticons.length;

            if (index == elen) {
                int sub = 0;
                int cost = 0;

                for(int[] user: users) {
                    int userDisRate = user[0];
                    int userMaxCost = user[1];

                    int sum = 0;

                    for (int i=0; i<elen; i++) {
                        if (discounts[i] >= userDisRate) {
                            sum += emoticons[i]/100*(100-discounts[i]);
                        }
                    }

                    if (sum >= userMaxCost) {
                        sub++;
                    } else {
                        cost += sum;
                    }
                }

                if (sub > maxSub) {
                    maxSub = sub;
                    maxCost = cost;
                } else if (sub == maxSub) {
                    maxCost = Math.max(maxCost, cost);
                }
                return;
            }

            for (int i=0; i<4; i++) {
                discounts[index] = discount[i];
                find(index + 1, discounts, users, emoticons);
            }
        }
    }
}
