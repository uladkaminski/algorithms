import com.uladkaminski.sorting.MergeSort;
import com.uladkaminski.sorting.QuickSort;
import com.uladkaminski.sorting.Sort;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

public class SortTest {
    public Map<int[], int[]> data = Map.of(
            new int[]{1}, new int[]{1},
            new int[]{}, new int[]{},
            new int[]{5,4,3,2,1}, new int[]{1,2,3,4,5},
            new int[]{4,1,2,3,5}, new int[]{1,2,3,4,5}
            );


    @Test
    public void quickSortTest() {
        QuickSort sort = new QuickSort();

        sortAsset(sort);
    }

    @Test
    public void mergeSortTest() {
        MergeSort sort = new MergeSort();

        sortAsset(sort);
    }

    private void sortAsset(Sort sort) {
        data.forEach((input, expected) -> {
            int[] actual = sort.sort(input);

            assert Arrays.equals(actual, expected);
        });
    }
}
