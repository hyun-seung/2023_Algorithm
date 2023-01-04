package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 배_1092 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int N;   // 크레인 수
    private static List<Integer> cranes = new ArrayList<>();
    private static int M;   // 박스 수
    private static List<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        setBase();

        System.out.print(solve());
    }

    private static int solve() {
        int result = 0;

        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > cranes.get(0)) {
            return -1;
        }

        while (!boxes.isEmpty()) {
            result++;
            removeBoxByCranes();
        }

        return result;
    }

    private static void removeBoxByCranes() {
        for (Integer crane : cranes) {
            removeBox(crane);
        }
    }

    private static void removeBox(Integer crane) {
        for (int i = 0; i < boxes.size(); i++) {
            if (crane >= boxes.get(i)) {
                boxes.remove(i);
                return;
            }
        }
    }

    private static void setBase() throws IOException {
        N = Integer.parseInt(reader.readLine());
        String inputCrane = reader.readLine();
        String[] inputCranes = inputCrane.split(" ");

        cranes.clear();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(inputCranes[i]));
        }

        M = Integer.parseInt(reader.readLine());
        String inputBox = reader.readLine();
        String[] inputBoxes = inputBox.split(" ");

        boxes.clear();
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(inputBoxes[i]));
        }
    }
}
