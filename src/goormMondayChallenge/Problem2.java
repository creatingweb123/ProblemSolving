package goormMondayChallenge;

import java.io.*;

public class Problem2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        String name = input[1];

        int result = 0;
        for (int i = 0; i < N; i++) {
            String studentName = br.readLine();
            if (studentName.contains(name)) {
                result += 1;
            }
        }

        System.out.println(result);
    }
}
