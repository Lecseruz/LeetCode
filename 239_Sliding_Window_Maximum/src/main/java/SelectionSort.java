import java.util.Arrays;

// You can print the values to stdout for debugging
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{3, 2, 1, 4, 1})));
    }

    public static int[] sortArray(int arr[]) {
        int x = 0, y = 0, n = arr.length;
        for (x = 0; x < n; x++) {
            int index_of_min = x;
            for (y = x; y < n; y++) {
                if (arr[y] < arr[x]) {
                    index_of_min = y;
                }
            }
            int temp = arr[x];
            arr[x] = arr[index_of_min];
            arr[index_of_min] = temp;
        }
        return arr;
    }
} 