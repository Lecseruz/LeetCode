import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("abcbdef"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring("pkwwef"));


    }
    public int lengthOfLongestSubstring(String s) {
        int m = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            Integer value = map.get(s.charAt(i));
            if (value != null) {
                if (map.size() > m) {
                    m = map.size();
                }
                map = map.entrySet().stream().filter(characterIntegerEntry ->
                        characterIntegerEntry.getValue() > value
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            }
            map.put(s.charAt(i), i);
        }
        if(map.size() > m){
            m = map.size();
        }
        return m;
    }
}