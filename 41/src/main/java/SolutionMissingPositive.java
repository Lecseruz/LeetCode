import java.util.HashMap;
import java.util.Map;

class SolutionMissingPositive
{
    public static void main(String[] args)
    {
        SolutionMissingPositive solutionMissingPositive = new SolutionMissingPositive();
        System.out.println(solutionMissingPositive.firstMissingPositive(new int[]{-5, 1000}));
    }

    public int firstMissingPositive(int[] nums)
    {
        final Map<Integer, Integer> map = new HashMap<>();
        int min = 1;
        for (int num : nums)
        {
            if (num < min)
            {
                min = num;
            }
            map.put(num, num);
            map.put(num, num);
        }
        if (min < 1){
            min = 1;
        }
        while (map.get(min) != null)
        {
            ++min;
        }
        return min;
    }
}