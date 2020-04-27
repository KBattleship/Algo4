package sort.compare.merge;

/**
 * @ClassName: DoubleMergeSort
 * @Description: 两路归并排序
 * @Author: CheneyIn
 * @Date: 2020/4/27
 */
public class DoubleMergeSort {

    /*
        归并排序采用分治思想
            将长度为n的数列分成两个n/2长度的子数列，对两个子数列分别进行归并，最终将两个子数列合并成最终的排序数列
        以下实现方法未采用递归方式
     */
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        // 申请长度与arr相同内存的数组，作为排序辅助数组
        int x[] = new int[arr.length];
        int s = 1;
        while (s < arr.length) {    //  这里不可以<=，否则严重越界
            // 合并 arr 到 x
            mergeSort(arr, x, s);
            s *= 2;
            // 合并 x 到 arr
            mergeSort(x, arr, s);
            s *= 2;
        }
        return arr;
    }

    /**
     * 用于合并两个排序好的相邻的两个数组段
     *
     * @param x 数列1(原始数组)
     * @param y 数列2(辅助数组)
     * @param s 合并大小(阈值)
     */
    private void mergeSort(int[] x, int[] y, int s) {
        // 开始下标
        int i = 0;
        /*
            从第一个元素开始，合并大小为s的相邻2端子数组
         */
        // i+s*2要小于等于数组长度，也就是说为合并的元素个数要大于2*s个
        while (i + 2 * s <= x.length) { // 此循环次数为x.length/(2*s)
            merge(x, y, i, i + s - 1, i + 2 * s - 1);
            i += 2 * s;
        }
        // 未合并的元素个数要大于1*s
        if (i + s < x.length) {
            merge(x, y, i, i + s - 1, x.length - 1);
        } else {
            // 为合并的元素个数小于1*s，直接复制到数组y
            while (i < x.length) {
                y[i] = x[i];
                i++;
            }
        }
    }

    /**
     * @param x     待合并数组(已完成排序)
     * @param y
     * @param left  数组x的left下标
     * @param mid   数组x的中位下标
     * @param right 数组x的right下标
     */
    private void merge(int[] x, int[] y, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        // 两端进行比较，最值放入y数组
        while (i <= mid && j <= right) {
            if (x[i] < x[j]) {
                y[k++] = x[i++];
            } else {
                y[k++] = x[j++];
            }
        }
        /*
            如果数组左侧部分最大的几个元素值大于右侧部分，左侧就剩下未放入数组y的元素
            或者理解为：上方while循环中 j>right 终止跳出while，但是 i<mid
            此操作是两种极端情况的补偿。
         */
        // 当 i<mid
        while (i <= mid) {
            y[k++] = x[i++];
        }
        // 当 j<right 并 i>mid 的情况
        while (j <= right) {
            y[k++] = x[j++];
        }
    }
}
