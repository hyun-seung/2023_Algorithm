package org.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int e : tangerine) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (Integer o1, Integer o2) -> {
            return map.get(o2) - map.get(o1);
        });

        for(int e : list){
            if(k > 0){
                k -= map.get(e);
                answer++;
            }
            else break;
        }

        return answer;
    }
}
