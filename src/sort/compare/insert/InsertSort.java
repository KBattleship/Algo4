package sort.compare.insert;

/**
 * @ClassName: InsertSort
 * @Description: 插入排序
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class InsertSort {

    /*
        默认数列中第一个元素为已经排序的，获取下一个元素，与已经排序的数列元素依次进行判断
        如果当前元素大于新元素，将新元素移动到当前元素位置
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int curr = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] < curr; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = curr;
        }

        return arr;
    }
}
