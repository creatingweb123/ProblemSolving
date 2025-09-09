import java.io.*;
import java.util.Arrays;

public class Problem4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        String[] valueList = br.readLine().split(" ");
        boolean[] isPrime = primeNumberList(N);
        long result = 0L;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                result += Integer.parseInt(valueList[i - 1]);
            }

        }
        System.out.println(result);
    }

    public static boolean[] primeNumberList(int N) {
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

}