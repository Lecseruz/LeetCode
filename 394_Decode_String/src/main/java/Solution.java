import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int value = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                value = value * 10 + Character.getNumericValue(s.charAt(i));
            }
            if(Character.isAlphabetic(s.charAt(i))){

            }
            if(s.charAt(i) == '['){
                stack.push(String.valueOf(value));
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        return builder.toString();
    }
}