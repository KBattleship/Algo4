package leetcode.daily;

/**
 * @ClassName: SortArray_912
 * @Description: 排序数组
 * @Author: CheneyIn
 * @Date: 2020-03-31
 */
public class SortArray_912 {
    /*
        给你一个整数数组 nums，将该数组升序排列。

        示例 1：
        输入：nums = [5,2,3,1]
        输出：[1,2,3,5]

        示例 2：
        输入：nums = [5,1,1,2,0,0]
        输出：[0,0,1,1,2,5]

        提示：
        1 <= nums.length <= 50000
        -50000 <= nums[i] <= 50000
     */

    // 1.冒泡排序
    private static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println("第I个数字" + array[i]);
            for (int j = 0; j < array.length - 1 - i; j++) {
                System.out.println("第J个数字" + array[j]);
                System.out.println("第J+1个数字" + array[j+1]);
                if (array[j] > array[j + 1]) {
                    int v = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = v;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 1, 2, 0, 0};
        for (int i : sortArray(array)) {
            System.out.println(i);
        }
    }
}
