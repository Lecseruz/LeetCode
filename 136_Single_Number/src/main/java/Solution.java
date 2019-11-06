class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int val : nums){
            num ^= val;
        }
        return num;
    }
}