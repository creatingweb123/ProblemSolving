import java.io.*;

public class Problem10 {
    private static final char[][] KEYPAD = {
            {}, // 0번 인덱스는 사용 안 함
            { '1', '.', ',', '?', '!' }, // 1
            { '2', 'A', 'B', 'C' }, // 2
            { '3', 'D', 'E', 'F' }, // 3
            { '4', 'G', 'H', 'I' }, // 4
            { '5', 'J', 'K', 'L' }, // 5
            { '6', 'M', 'N', 'O' }, // 6
            { '7', 'P', 'Q', 'R', 'S' }, // 7
            { '8', 'T', 'U', 'V' }, // 8
            { '9', 'W', 'X', 'Y', 'Z' } // 9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String sentence = br.readLine();

        StringBuilder result = new StringBuilder(N); // 추가 메모리 할당 방지

        int beforeNumber = sentence.charAt(0) - '0';
        int count = 0;

        for (int i = 0; i < N; i++) {
            int currentNumber = sentence.charAt(i) - '0';
            if (beforeNumber != currentNumber) {
                result.append(intToChar(beforeNumber, count));
                count = 1;
                beforeNumber = currentNumber;
            } else {
                count++;
            }
        }
        result.append(intToChar(beforeNumber, count));
        System.out.println(result);
    }

    private static char intToChar(int n, int count) {
        char[] chars = KEYPAD[n];
        int index = (count - 1) % chars.length;
        return chars[index];
    }
}
