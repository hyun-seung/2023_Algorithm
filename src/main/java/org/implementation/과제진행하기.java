package org.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class 과제진행하기 {

    static class Task {
        private String name;
        private int startTime;
        private int playTime;

        Task(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }

        Task(String name, int playTime) {
            this.name = name;
            this.playTime = playTime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        PriorityQueue<Task> pq = new PriorityQueue<>(
                (o1, o2) -> (o1.startTime - o2.startTime)
        );

        for (int i = 0; i < plans.length; i++) {
            String time = plans[i][1];
            String[] times = time.split(":");
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int startTime = (h * 60) + m;

            int playTime = Integer.parseInt(plans[i][2]);

            pq.add(new Task(plans[i][0], startTime, playTime));
        }

        Stack<Task> remainingTasks = new Stack<>();

        while (!pq.isEmpty()) {
            Task now = pq.poll();

            String nowName = now.name;
            int nowStart = now.startTime;
            int nowPlay = now.playTime;

            int currentTime = nowStart;

            if (!pq.isEmpty()) {
                Task next = pq.peek();

                if (currentTime + nowPlay < next.startTime) {
                    answer.add(nowName);
                    currentTime += nowPlay;

                    while (!remainingTasks.isEmpty()) {
                        Task remainingTask = remainingTasks.pop();

                        if (currentTime + remainingTask.playTime <= next.startTime) {
                            answer.add(remainingTask.name);
                            currentTime += remainingTask.playTime;
                            continue;
                        } else {
                            int discountTime = next.startTime - currentTime;
                            remainingTasks.add(new Task(remainingTask.name, remainingTask.playTime - discountTime));
                            break;
                        }
                    }
                } else if (nowStart + nowPlay == next.startTime) {
                    answer.add(nowName);
                    continue;
                } else {
                    int discountTime = next.startTime - currentTime;
                    remainingTasks.push(new Task(nowName, nowPlay - discountTime));
                }
            } else {
                if (remainingTasks.isEmpty()) {
                    answer.add(nowName);
                } else {
                    answer.add(nowName);

                    while (!remainingTasks.isEmpty()) {
                        Task rem = remainingTasks.pop();
                        answer.add(rem.name);
                    }
                }
            }
        }

        String[] answers = answer.toArray(new String[0]);

        return answers;
    }
}
