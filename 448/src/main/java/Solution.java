import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findDisappearedNumbers(new int[]{1, 1});
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        byte[] array = new byte[nums.length + 1] ;
        for (int i = 0; i < nums.length; ++i) {
            array[nums[i]] = 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < nums.length; ++i) {
            if(array[i] == 0){
                list.add(i);
            }
        }
        return list;
    }
}
