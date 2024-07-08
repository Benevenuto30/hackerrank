import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HRbirthdayCakeCandles {
    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int tallerCandle = 0;
        int qtdCandles = 0;

        for (int numbers : candles) {
            if (numbers > tallerCandle) {
                tallerCandle = numbers;
            }
        }
        for (int times : candles) {
            if (times == tallerCandle) {
                qtdCandles++;
            }
        }
        return qtdCandles;
    }


    public static class Solution {

        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = HRbirthdayCakeCandles.birthdayCakeCandles(candles);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}

