public class Solution
{
    public static int binarySearch(int arr[], int first, int last, int key)
    {
        int sum = 0;
        int mid = (first + last) / 2;
        while (first <= last)
        {
            if (arr[mid] < key)
            {
                first = mid + 1;
            }
            else if (arr[mid] == key)
            {
                break;
            }
            else
            {
                last = mid - 1;
            }
            sum += mid + 1;
            mid = (first + last) / 2;
        }
        return sum;
    }

    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int last = arr.length - 1;
        System.out.println(binarySearch(arr, 0, last, 10));
    }
}
