import java.io.*;

public class Problem1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long result = 1L;

        String input = br.readLine();
        int N = Integer.parseInt(input);

        String bridgeNum = br.readLine();
        String[] numStrList = bridgeNum.split(" ");
        for (int i = 0; i < N; i++) {
            result *= Integer.parseInt(numStrList[i]);
        }
        System.out.println(result);
    }
}
