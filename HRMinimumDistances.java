import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class HRMinimumDistances {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);

            // Verifica se o elemento ja foi encontrado antes
            if (lastIndexMap.containsKey(current)) {
                int lastIndex = lastIndexMap.get(current);
                int currentDistance = i - lastIndex;

                // Atualiza a menor distancia encontrada ate agora
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }

            // Atualiza o ultimo indice do elemento atual no mapa
            lastIndexMap.put(current, i);
        }

// Se minDistance nao mudou, nao encontramos elementos repetidos
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }


    public static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = HRMinimumDistances.minimumDistances(a);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}
