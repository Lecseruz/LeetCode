class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); ++j) {
            if (i == s.length()) {
                break;
            }
            if (t.charAt(j) == s.charAt(i)) {
                ++i;
            }
        }
        return s.length() == i;
    }
}