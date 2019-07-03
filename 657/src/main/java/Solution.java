public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        int horizontal = 0;
        int vertical = 0;
        for (int i = 0; i < moves.length(); ++i) {
            switch (moves.charAt(i)) {
                case 'L': {
                    --horizontal;
                    break;
                }
                case 'U': {
                    ++vertical;
                    break;
                }
                case 'D': {
                    --vertical;
                    break;
                }
                case 'R': {
                    ++horizontal;
                    break;
                }
                default:
                    break;
            }
        }
        return horizontal == 0 && vertical == 0;
    }
}
