package goormMondayChallenge;

import java.io.*;
import java.util.StringTokenizer;

public class Problem8 {

    // 의미 있는 상수 정의
    private static final int SINGLE_CELL_VALUE = 1;
    private static final int CORNER_VALUE = 3;
    private static final int EDGE_VALUE = 4;
    private static final int INNER_VALUE = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 땅의 크기
        int K = Integer.parseInt(st.nextToken()); // 폭탄 횟수

        int total = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            total += getCellValue(N, x, y);
        }

        System.out.println(total);
    }

    /**
     * 특정 좌표(x,y)에 따른 값을 계산
     */
    private static int getCellValue(int N, int x, int y) {
        if (N == 1)
            return SINGLE_CELL_VALUE;

        boolean isCorner = (x == 1 || x == N) && (y == 1 || y == N);
        boolean isEdge = (x == 1 || x == N || y == 1 || y == N);

        if (isCorner)
            return CORNER_VALUE;
        if (isEdge)
            return EDGE_VALUE;
        return INNER_VALUE;
    }
}
