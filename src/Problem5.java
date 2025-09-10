import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // 학생 수
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] scores = new int[N];
            int total = 0;

            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                total += scores[j];
            }

            double average = (double) total / N;
            int count = 0;

            for (int score : scores) {
                if (score >= average) {
                    count++;
                }
            }

            System.out.println(count + "/" + N);
        }
    }
}
