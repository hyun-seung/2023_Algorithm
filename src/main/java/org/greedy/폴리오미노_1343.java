package org.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노_1343 {

    /*
        2 종류의 폴리오미노 : AAAA 와 BB
        . 과 X 로 이루어진 보드판
        X 를 모두 덮는다
        . 는 덮으면 안 된다.
        사전순으로 가장 앞서는 답을 출력한다 (4개 기준 AAAA로 할 것, BBBB로 하면 사전순 X)
        덮을 수 없는 경우 -1
     */

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String target;

    public static void main(String[] args) throws IOException {
        setTarget();

        System.out.print(solve());
    }

    private static String solve() {
        String A = "AAAA";
        String B = "BB";

        target = target.replaceAll("XXXX", A);
        target = target.replaceAll("XX", B);

        if (target.contains("X")) {
            return "-1";
        }
        return target;
    }

    public static void setTarget() throws IOException {
        target = reader.readLine();
    }
}
