class Solution {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.countSubstrings("abc"));
    }
    public int countSubstrings(String s) {
        var count = s.length();
        var interval = 2;
        while (interval <= s.length()){
            for (int i = 0; i + interval <= s.length(); ++i){
                var palindrom =  s.substring(i, i + interval);
                if(isPalindrom(palindrom)){
                    ++count;
                }
            }
            ++interval;
        }
        return count;
    }

    private boolean isPalindrom(String palindrom)
    {
        return palindrom.equals(new StringBuilder(palindrom).reverse().toString());
    }
}