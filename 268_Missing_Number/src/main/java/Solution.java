class Solution {
    public int missingNumber(int[] nums) {
        int missValue = 0;
        for(int i = 0; i < nums.length; ++i){
            missValue ^= i;
            missValue ^= nums[i];
        }
        missValue ^= nums.length;
        return missValue;
    }
}