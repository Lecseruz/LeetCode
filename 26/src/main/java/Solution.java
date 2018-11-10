import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


class Solution {
    public static void main(String[] args)
    {
        int[] nums = {1, 2, 2, 3, 4};
        Solution solution = new Solution();
        int len = solution.removeDuplicates(nums);

        // any modification to nums in your function would be known by the caller.
        // using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
    public int removeDuplicates(int[] nums) {
        final Set<Integer> integerSet = new TreeSet<>();
        for (int el : nums){
            integerSet.add(el);
        }
        List<Integer> array = new ArrayList<>(integerSet);
        for (int i = 0; i < array.size(); ++i){
            nums[i] = array.get(i);
        }
        return integerSet.size();
    }
}