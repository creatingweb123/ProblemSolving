package goormMondayChallenge;

import java.io.*;
import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] vList = new int[4];
        for (int i = 0; i < 4; i++) {
            vList[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(vList);
        int result = vList[3] + vList[2] - vList[1] - vList[0];
        System.out.println(result);
    }
}
