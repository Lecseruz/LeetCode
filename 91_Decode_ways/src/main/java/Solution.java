import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("1100"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int same = 0;
        int different = 1;
        for (int i = 1; i < s.length(); ++i) {
            int value = Integer.parseInt(s.substring(i - 1, i + 1));
            if (s.charAt(i) == '0') {
                same = different;
                different = 0;
            } else if (value <= 26) {
                int temp = same;
                same = different;
                different = temp + different;
            } else {
                different += same;
                same = 0;
            }
            if (value > 26 && s.charAt(i) == '0')
                return 0;
            if (value == 0)
                return 0;
        }
        return same + different;
    }
}
