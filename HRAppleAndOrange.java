import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class HRAppleAndOrange {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s staring point of Sams house
     *  2. INTEGER t ending location of Sams house
     *  3. INTEGER a location of the apple tree
     *  4. INTEGER b location of the orange tree
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        // Write your code here
        int orange = 0;
        int apple = 0;
        int arrayApples = apples.size();
        int arrayOragnes = oranges.size();

        for (int i = 0; i < arrayApples; i++) {
            int element = apples.get(i);

            if (element + a >= s && element + a <= t) {
                orange = orange + 1;
            }
        }
        for (int i = 0; i < arrayOragnes; i++) {
            int element = oranges.get(i);
            if (element + b >= s && element + b <= t) {
                apple = apple + 1;
            }
        }
        System.out.println(orange);
        System.out.println(apple);

    }


    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int s = Integer.parseInt(firstMultipleInput[0]);

            int t = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int a = Integer.parseInt(secondMultipleInput[0]);

            int b = Integer.parseInt(secondMultipleInput[1]);

            String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int m = Integer.parseInt(thirdMultipleInput[0]);

            int n = Integer.parseInt(thirdMultipleInput[1]);

            List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            HRAppleAndOrange.countApplesAndOranges(s, t, a, b, apples, oranges);

            bufferedReader.close();
        }
    }
}
