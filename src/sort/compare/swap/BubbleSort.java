package sort.compare.swap;

/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class BubbleSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            // 用于标记，优化算法
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    flag = true;
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            // 优化排序，当内部一轮比较都没有触发时不再进行比较，直接结束循环
            if (!flag) {
                break;
            }
        }
        return arr;
    }
}
