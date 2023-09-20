package org.implementation;

public class 마법의엘리베이터 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;

            String s = String.valueOf(storey);
            int[] arr = new int[s.length()];

            for (int i=0; i<arr.length; i++) {
                arr[i] = s.charAt(i) - '0';
            }

            for (int i=arr.length - 1; i >= 0; i--) {
                if (arr[i] > 5) {
                    answer += 10 - arr[i];

                    if (i == 0) {
                        answer += 1;
                    } else {
                        arr[i-1]++;
                    }
                } else if (arr[i] == 5 && i>0 && arr[i-1] >= 5) {
                    arr[i-1]++;
                    answer += 5;
                } else {
                    answer += arr[i];
                }
            }

            return answer;
        }
    }
}
