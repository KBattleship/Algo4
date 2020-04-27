package sort.compare.insert;

/**
 * @ClassName: ShellSort
 * @Description: 希尔排序
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class ShellSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        // 希尔增量计算，对待排序数列进行分割
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i += gap) {
                int curr = arr[i];
                int j = i - gap;
                for (; j >= 0 && arr[j] > curr; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = curr;
            }
        }
        return arr;
    }
}
