package goormMondayChallenge;

import java.io.*;

import java.util.StringTokenizer;

public class Problem9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] valueList = new int[200001];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > 0)
                valueList[value] += 1;
            else
                valueList[-value] -= 1;
        }
        long result = 0;
        for (int i = 1; i < 200001; i++) {
            result += valueList[i] * i;
        }

        System.out.println(result);
    }
}