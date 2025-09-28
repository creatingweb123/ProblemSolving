package goormMondayChallenge;

import java.io.*;
import java.util.*;

/**
 * 공원 시뮬레이션 문제
 * 각 칸의 나무/풀 상태를 시뮬레이션하며
 * 모든 칸이 0이 될 때까지 경과한 사이클 수를 계산
 */
public class Problem14 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] park = new int[N + 2][N + 2];
        for (int[] row : park) {
            Arrays.fill(row, -1); // 경계 처리
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                park[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ParkSimulator simulator = new ParkSimulator(park, N);
        System.out.println(simulator.simulateUntilEmpty());
    }
}

/** 공원 시뮬레이션 로직 전용 클래스 */
class ParkSimulator {
    private int[][] park;
    private final int N;
    private static final int[][] DIRECTIONS = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
    };

    public ParkSimulator(int[][] park, int N) {
        this.park = park;
        this.N = N;
    }

    /** 전체가 0이 될 때까지 사이클 수 계산 */
    public int simulateUntilEmpty() {
        int cycleCount = 0;
        while (hasRemainingPlants()) {
            cycleCount++;
            simulateCycle();
        }
        return cycleCount;
    }

    /** 한 번의 사이클 시뮬레이션 */
    private void simulateCycle() {
        int[][] decay = new int[N + 2][N + 2];

        // 각 칸의 이웃 개수 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int[] d : DIRECTIONS) {
                    int ni = i + d[0], nj = j + d[1];
                    if (park[ni][nj] == 0) {
                        decay[i][j]++;
                    }
                }
            }
        }

        // decay 값만큼 줄이고 0 이하 방지
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                park[i][j] = Math.max(0, park[i][j] - decay[i][j]);
            }
        }
    }

    /** 아직 양수 상태인 칸이 있는지 확인 */
    private boolean hasRemainingPlants() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (park[i][j] > 0)
                    return true;
            }
        }
        return false;
    }
}
