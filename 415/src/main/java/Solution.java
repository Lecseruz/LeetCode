class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("999", "111"));
    }

    public String addStrings(String num1, String num2) {
        int minLength = num1.length() > num2.length() ? num2.length() : num1.length();
        String max = num1.length() < num2.length() ? num2 : num1;

        StringBuilder builder = new StringBuilder();
        int k = 0;
        for (int i = 1; i <= minLength; ++i) {
            int value1 = Integer.parseInt(String.valueOf(num1.charAt(num1.length() - i)));
            int value2 = Integer.parseInt(String.valueOf(num2.charAt(num2.length() - i)));
            int value = value1 + value2 + k;
            k = value / 10;
            builder.append(value % 10);
        }
        for (int i = minLength + 1; i <= max.length(); ++i) {
            int value = Integer.parseInt(String.valueOf(max.charAt(max.length() - i)));
            value = value + k;
            k = value / 10;
            builder.append(value % 10);
        }
        if (k == 1){
            builder.append(k);
        }
        return builder.reverse().toString();
    }
}