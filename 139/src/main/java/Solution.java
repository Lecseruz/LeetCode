import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("apple", "pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        Arrays.fill(dp, false);
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                if (s.substring(i).startsWith(wordDict.get(j)) && (i == 0 || dp[i-1])) {
                    dp[i + wordDict.get(j).length() - 1] = true;
                }
            }
        }
        return dp[s.length() - 1];
    }
}