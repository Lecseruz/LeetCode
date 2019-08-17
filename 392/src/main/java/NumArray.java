import java.util.HashMap;
import java.util.Map;

class NumArray {

    private Map<Map.Entry<Integer, Integer>, Integer> map = new HashMap<>();

    public NumArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                map.put(new HashMap.SimpleEntry<>(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return map.get(new HashMap.SimpleEntry<>(i, j));
    }
}