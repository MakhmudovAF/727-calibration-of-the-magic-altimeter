import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[10];
        int bestSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }

        for (int mask = 0; mask < (1 << 10); mask++) {
            int currentSum = 0;

            for (int i = 0; i < 10; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentSum += nums[i];
                }
            }

            int diff = Math.abs(currentSum - 100);

            if (diff < minDiff) {
                minDiff = diff;
                bestSum = currentSum;
            }

            else if (diff == minDiff) {
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                }
            }
        }

        writer.write(String.valueOf(bestSum));

        reader.close();
        writer.close();
    }
}