import java.util.Arrays;

// You can print the values to stdout for debugging
public class ArraySort{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{22, 12, 21, 123})));
    }
    public static int[] sortArray( int arr[] ){
        int i , max , location , j , temp , len = arr.length;
        for( i = 0 ; i < len ; i ++ ){
            max = arr[i];
            location = i;
            for( j = i ; j < len ; j ++ ){
                if( max < arr[j] ){
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }
}