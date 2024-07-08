import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class HRGradingStudents {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> result = new ArrayList();

        for (int i : grades) {
            int gradePlus1 = i + 1;
            int gradePlus2 = i + 2;

            if (gradePlus1 % 5 == 0 && i >= 40) {
                result.add(gradePlus1);
            } else if (gradePlus2 % 5 == 0 && i >= 40) {
                result.add(gradePlus2);
            } else if (gradePlus1 % 5 != 0 && i >= 40) {
                result.add(i);
            } else if (gradePlus2 % 5 != 0 && i >= 40) {
                result.add(i);
            } else if (gradePlus1 == 40) {
                result.add(gradePlus1);
            } else if (gradePlus2 == 40) {
                result.add(gradePlus2);
            } else if (gradePlus1 < 40) {
                result.add(i);
            } else if (gradePlus2 < 40) {
                result.add(i);
            }
        }
        return result;
    }

    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = HRGradingStudents.gradingStudents(grades);

            bufferedWriter.write(
                    result.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\n"
            );

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
