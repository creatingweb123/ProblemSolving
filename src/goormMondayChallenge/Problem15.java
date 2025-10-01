package goormMondayChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem15 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StickerSimulator simulator = new StickerSimulator(N);
        System.out.println(simulator.getTotalStickers());
    }
}

class StickerSimulator {
    private int[] stickers;
    private final int rounds;

    // 스티커 개수
    private static final int SIZE = 5;

    // 각 스티커가 다음 상태에서 더해질 인덱스 매핑
    private static final int[][] TRANSITIONS = {
            { 0, 1, 2, 3, 4 }, // 0번 스티커 → 모든 칸에 영향
            { 0, 2, 3 }, // 1번 스티커
            { 0, 1, 3, 4 }, // 2번 스티커
            { 0, 1, 2 }, // 3번 스티커
            { 0, 2 } // 4번 스티커
    };

    public StickerSimulator(int rounds) {
        this.rounds = rounds;
        this.stickers = new int[SIZE];
        Arrays.fill(this.stickers, 1); // 초기 상태는 모두 1
    }

    public int getTotalStickers() {
        for (int i = 1; i < rounds; i++) {
            updateStickerStates();
        }
        return Arrays.stream(stickers).sum() % 100000007;
    }

    private void updateStickerStates() {
        int[] next = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int target : TRANSITIONS[i]) {
                next[target] += stickers[i];
            }
        }
        for (int i = 0; i < SIZE; i++) {
            next[i] %= 100000007;
        }
        stickers = next;
    }
}
