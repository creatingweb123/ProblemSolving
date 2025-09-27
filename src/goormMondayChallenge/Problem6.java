package goormMondayChallenge;

import java.io.*;

public class Problem6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        char beforeChar = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (beforeChar != S.charAt(i)) {
                beforeChar = S.charAt(i);
                result += 1;
            }
        }
        System.out.println(result);
    }
}