import com.polaris.algorithms.sorting.*;
import com.polaris.utils.Asserts;
import com.polaris.utils.Integers;

import java.util.Arrays;

/**
 * @Author polaris
 * @Date 2021/1/30 22:17
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class SortTest {
    public static void main(String[] args) {
        Integer[] arr1 = Integers.random(10000, 1, 20000);
        testSort(arr1,
                new SelectionSort(),
                new HeapSort(),
                new BubbleSort(),
                new InsertionSort());

    }

    static void testSort(Integer[] arr,Sort... sorts) {
        for (Sort sort: sorts) {
            Integer[] newArr = Integers.copy(arr);
            sort.sort(newArr);
            //检查排序正确性
            Asserts.test(Integers.isAscOrder(newArr));
        }
        Arrays.sort(sorts);
        for (Sort sort: sorts) {
            System.out.println(sort);
        }
    }
}
