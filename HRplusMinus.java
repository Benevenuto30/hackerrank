import java.io.*;
import java.text.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

public class HRplusMinus {

    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int positionResult = 0;

        String resultFormat1;
        String resultFormat2;
        String resultFormat3;

        for (int positions : arr) {
            if (positions > 0) {
                positive++;
                positionResult++;

            } else if (positions < 0) {
                negative++;
                positionResult++;
            } else {
                zero++;
                positionResult++;
            }
        }

        double resultPositive = (double) positive / positionResult;
        double resultNegative = (double) negative / positionResult;
        double resultZero = (double) zero / positionResult;

        DecimalFormat deci = new DecimalFormat("0.000000");
        resultFormat1 = deci.format(resultPositive);
        resultFormat2 = deci.format(resultNegative);
        resultFormat3 = deci.format(resultZero);

        System.out.println(resultFormat1);
        System.out.println(resultFormat2);
        System.out.println(resultFormat3);

    }


    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            HRplusMinus.plusMinus(arr);

            bufferedReader.close();
        }
    }
}
