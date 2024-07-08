import java.io.*;

public class HRTimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    static class Result {
        public static String timeConversion(String s) {
            // Write your code here
            String firstTwoDigits = s.substring(0, 2);
            String middleDigits = s.substring(2, 8);
            String lastTwoDigits = s.substring(s.length() - 2);
            String complement = "";
            String result = "";
            String result2 = "";
            String result3 = "";
            int hour = Integer.parseInt(firstTwoDigits);

            if (hour < 12 && lastTwoDigits.equals("PM")) {
                hour = hour + 12;
                lastTwoDigits = "";
                result2 = Integer.toString(hour);
            }

            if (hour == 12 && lastTwoDigits.equals("PM")) {
                complement = Integer.toString(hour);
            }

            if (hour < 10) {
                result = Integer.toString(hour);
                complement = "0" + result;
            }

            if (hour >= 10 && hour < 12) {
                result3 = Integer.toString(hour);
                complement = result3;
            }

            if (hour == 12 && lastTwoDigits.equals("AM")) {
                complement = "00";
            }

            return complement + result2 + middleDigits;
        }

    }
}
