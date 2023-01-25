package algorithm;

import java.util.Arrays;
import java.util.stream.Stream;

public class 배열합치기 {

    public static void main(String[] args) {
        Integer []arr1 = {1, 2, 3};
        Integer []arr2 = {4, 5};

        Integer []arr = Stream
                .concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .toArray(Integer[]::new);

        // 여기까진 Intger로 변환할 때.
        // Integer to int array
        int int_arr[] = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
//        int int_arr_2[] = Arrays.stream(arr).mapToInt(i->i).toArray();

        //int to Integer array
        int a[] = {1, 2, 3, 4};
        Integer b[] = Arrays.stream(a).boxed().toArray(Integer[]::new);

        System.out.println("Stream API 사용 시 " + Arrays.toString(int_arr));


        //System.arraycopy()
        int arrcopy[] = new int[arr1.length + arr2.length];

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, 0, arr2.length);
    }
}
