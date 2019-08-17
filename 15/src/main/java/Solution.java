import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.threeSum(new int[]{-1, -1, 2});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;
        for (int value : nums) {
            Integer count = map.get(value);
            if (count == null) {
                map.put(value, 1);
            } else {
                map.put(value, ++count);
            }
        }
        Integer integer = map.getOrDefault(0, 0);
        if(integer >= 3){
            addList(lists, 0, 0, 0);
        }
        Map<Integer, Integer> mapClone = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) map).clone();
        if (integer != 0) {
            map.remove(0);
            mapClone.remove(0);
            for (Integer value : new ArrayList<>(map.keySet())) {
                int newValue = value * -1;
                if (map.get(newValue) != null && value != 0) {
                    map.remove(value);
                    addList(lists, value, 0, newValue);
                }
            }
        }
        for (Integer value : mapClone.keySet()) {
            if (value % 2 == 0) {
                int newValue = value * -1;
                int key = newValue / 2;
                Integer count = mapClone.getOrDefault(key, 0);
                if (count >= 2) {
                    addList(lists, newValue / 2, newValue / 2, value);
                }
            }
        }
        return lists;
    }

    private void addList(List<List<Integer>> lists, int value1, int value2, int value3) {
        List<Integer> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        list.add(value3);
        lists.add(list);
    }
}