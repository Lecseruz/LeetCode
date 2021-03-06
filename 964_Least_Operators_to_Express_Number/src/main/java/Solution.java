import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastOpsExpressTarget(3, 17));
    }

    Map<String, Integer> memo;
    int x;

    public int leastOpsExpressTarget(int x, int target) {
        memo = new HashMap();
        this.x = x;
        int i = dp(0, target) - 1;
        return i;
    }

    public int dp(int i, int target) {
        String code = "" + i + "#" + target;
        if (memo.containsKey(code))
            return memo.get(code);

        int ans;
        if (target == 0) {
            ans = 0;
        } else if (target == 1) {
            ans = cost(i);
        } else if (i >= 39) {
            ans = target + 1;
        } else {
            int t = target / x;
            int r = target % x;
            ans = Math.min(r * cost(i) + dp(i + 1, t),
                    (x - r) * cost(i) + dp(i + 1, t + 1));
        }
        memo.put(code, ans);
        return ans;
    }

    public int cost(int x) {
        return x > 0 ? x : 2;
    }

}