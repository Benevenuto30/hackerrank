
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class HRminiMaxSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        HRminiMaxSum.miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long max = 0;
        long min = 100000000000000L;
        long resultMax = 0;
        long resultMin = 0;
        long resultTotal = 0;

        for (int i : arr) {

            resultTotal = resultTotal + i;

            if (i > max) {
                max = i;
            }

            if (i < min) {
                min = i;
            }
        }
        resultMin = resultTotal - max;
        resultMax = resultTotal - min;

        System.out.println(resultMin + " " + resultMax);
    }
}