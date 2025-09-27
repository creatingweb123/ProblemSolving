package goormMondayChallenge;

import java.io.*;
import java.util.*;

public class Problem7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // K번째 학생

        Pair[] attendanceSheet = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double height = Double.parseDouble(st.nextToken());
            attendanceSheet[i] = new Pair(name, height);
        }

        // 키 기준 오름차순 정렬, 같으면 이름 기준 사전순 정렬
        Arrays.sort(attendanceSheet, Comparator
                .comparing((Pair p) -> p.name)
                .thenComparingDouble(p -> p.height));

        // K번째 학생 출력 (입력에서 1-based라고 가정)
        Pair kth = attendanceSheet[K - 1];
        System.out.printf("%s %.2f", kth.name, kth.height);
    }

    public static class Pair {
        String name;
        double height;

        public Pair(String name, double height) {
            this.name = name;
            this.height = height;
        }
    }
}
