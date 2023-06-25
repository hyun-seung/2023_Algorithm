package org.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 홀수홀릭_20164 {

    private static String N;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int temp = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = br.readLine();

        divide(N);
        System.out.println(min + " " + max);
    }

    private static void divide(String input) {
        if (input.length() >= 3) {
            for(int i=1; i<input.length()-1; i++) {
                for(int j=i+1; j<input.length(); j++) {

                    String a = input.substring(0, i);
                    String b = input.substring(i, j);
                    String c = input.substring(j);

                    temp += cal(a);
                    temp += cal(b);
                    temp += cal(c);

                    divide(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c)));

                    temp -= cal(a);
                    temp -= cal(b);
                    temp -= cal(c);
                }
            }
        } else if (input.length() == 2) {
            temp += input.charAt(0) % 2;
            temp += input.charAt(1) % 2;

            divide(String.valueOf(Integer.parseInt(String.valueOf(input.charAt(0))) + Integer.parseInt(String.valueOf(input.charAt(1)))));

            temp -= input.charAt(0) % 2;
            temp -= input.charAt(1) % 2;
        } else {
            temp += Integer.parseInt(input) % 2;

            max = Math.max(max, temp);
            min = Math.min(min, temp);

            temp -= Integer.parseInt(input) % 2;
            return;
        }
    }

    private static int cal(String num) {
        int count = 0;
        for(int i=0; i<num.length(); i++) {
            if(num.charAt(i) % 2 != 0)
                count++;
        }

        return count;
    }
}
