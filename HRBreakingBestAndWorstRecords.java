import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class HRBreakingBestAndWorstRecords {

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int bestRecord = scores.get(0);
        int worstRecord = scores.get(0);
        int bestRecordResult = 0;
        int worstRecordResult = 0;
        List<Integer> result = new ArrayList<>(2);

        for (int i : scores) {
            if (i > bestRecord) {
                bestRecord = i;
                bestRecordResult = bestRecordResult + 1;
            }
            if (i < worstRecord) {
                worstRecord = i;
                worstRecordResult = worstRecordResult + 1;
            }

        }
        result.add(bestRecordResult);
        result.add(worstRecordResult);
        return result;

    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = HRBreakingBestAndWorstRecords.breakingRecords(scores);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}

