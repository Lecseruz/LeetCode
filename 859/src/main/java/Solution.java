import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("ab", "ab"));
    }
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        LinkedList<Character> a1 = new LinkedList<>();
        LinkedList<Character> a2 = new LinkedList<>();
        int k = 0;
        for (int i = 0; i < A.length(); ++i){
            char aCharacter = A.charAt(i);
            char bCharacter = B.charAt(i);
            if(aCharacter != bCharacter){
                a1.add(aCharacter);
                a2.add(bCharacter);
                k++;
            }
        }
        if(k > 2){
            return false;
        }
        if(k == 0){
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); ++i){
                set.add(A.charAt(i));
            }
            if(set.size() == A.length()){
                return false;
            }
        }
        return a1.peekFirst() == a2.peekLast() && a2.peekFirst() == a1.peekLast();
    }
}