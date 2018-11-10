
class Solution
{
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[] {1, 8}));
    }

    public int maxArea(int[] height)
    {
        int maxArea = 0;
        for (int i = 0; i < height.length - 1; ++i)
        {
            for (int j = i + 1; j < height.length; ++j)
            {
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area > maxArea)
                {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}