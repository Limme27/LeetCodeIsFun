
import java.util.*;

public class Example {
        public static List<List<Integer>> findCombinations(List<Integer> numbers, int K) {
            // Initialize a 2D boolean array to track the subsets
            boolean[][] dp = new boolean[numbers.size() + 1][K + 1];
            dp[0][0] = true;
    
            // Compute the dynamic programming table
            for (int i = 1; i <= numbers.size(); i++) {
                int num = numbers.get(i - 1);
                for (int j = 0; j <= K; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= num) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - num];
                    }
                }
            }
    
            // Retrieve the combinations from the dynamic programming table
            List<List<Integer>> combinations = new ArrayList<>();
            retrieveCombinations(dp, numbers, numbers.size(), K, new ArrayList<>(), combinations);
            return combinations;
        }
    
        private static void retrieveCombinations(boolean[][] dp, List<Integer> numbers, int i, int j,
                                                 List<Integer> currentCombination, List<List<Integer>> combinations) {
            if (i == 0 && j == 0) {
                combinations.add(new ArrayList<>(currentCombination));
                return;
            }
    
            if (i <= 0 || j < 0 || !dp[i][j]) {
                return;
            }
    
            if (dp[i - 1][j]) {
                retrieveCombinations(dp, numbers, i - 1, j, currentCombination, combinations);
            }
    
            if (j >= numbers.get(i - 1) && dp[i - 1][j - numbers.get(i - 1)]) {
                currentCombination.add(numbers.get(i - 1));
                retrieveCombinations(dp, numbers, i - 1, j - numbers.get(i - 1), currentCombination, combinations);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    
        public static void main(String[] args) {
            List<Integer> a = List.of(1, 2, 3, 4, 5);
            int K = 6;
            List<Integer> b = List.of(2,2,5,1,2);
            int kk = 5;
            List<List<Integer>> combinations = findCombinations(a, K);
            List<List<Integer>> combinations1 = findCombinations(b, kk);
    
            // Print the combinations
            for (List<Integer> combination : combinations) {
                System.out.println(combination);
            }
            for (List<Integer> combination : combinations1) {
                System.out.println(combination);
            }
        }
}

