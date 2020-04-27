package sort.compare.select;

/**
 * @ClassName: SelectSort
 * @Description: 选择排序
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class SelectSort {
    /*
        选择排序思想：
            循环出每一轮中的最值，然后和当前位置的元素进行对调
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            // 记录每一轮循环中的最值
            int min = i;
            for (int j = i; j < arr.length; j++) {
                // 判断当前遍历到的元素是不是最值
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 把最值与当前元素的位置进行对调
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}
