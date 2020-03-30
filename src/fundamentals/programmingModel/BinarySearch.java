package fundamentals.programmingModel;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: 二分法查找
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 上午9:34 2018/9/12
 **
 ***/
public class BinarySearch {


    //特别需要注意此类中的一点：int[] params必须是有序的

    /*
        通过递归算法实现二分查找

        使用递归需要注意的三点：（违背任意一条都有可能会得到错误的结果或者最低效的代码）
            1.递归总有一个最简单的情况存在，即方法中的第一条语句总是一个包含return的条件语句；
            2.递归调用总是去尝试解决一个规模更小的子问题，这样递归才能收敛到简单的情况；
            3.递归调用的父问题和尝试解决的子问题之间不应该存在交集。
     */

    /**
     * 调用递归算法
     *
     * @param key       目标参数
     * @param headIndex 第一个参数索引
     * @param params    源参数即一组数
     * @return
     */
    public static int rank(int key, int headIndex, int[] params) {
        return rank(key, params, headIndex, params.length - 1);
    }

    /**
     * 递归算法实现
     *
     * @param key       目标参数
     * @param params    源参数即一组数
     * @param headIndex 第一个参数索引
     * @param endIndex  末尾参数索引
     * @return
     */
    private static int rank(int key, int[] params, int headIndex, int endIndex) {
        if (headIndex > endIndex) {
            return -1;
        }
        int mid = headIndex + (endIndex - headIndex) / 2;
        if (key < params[mid]) {
            return rank(key, params, headIndex, mid - 1);
        } else if (key > params[mid]) {
            return rank(key, params, mid + 1, endIndex);
        } else {

            return mid;
        }
    }

    /*
        使用最基础的代码实现二分法查找算法
     */

    /**
     *
     * @param key       目标参数,即要找到的对象
     * @param params    一组给定的参数
     * @return          返回结果，或者并没有在给定的数中找到
     */
    public static int rank(int key, int[] params) {
        int headIndex = 0;
        int endIndex = params.length - 1;
        while (headIndex <= endIndex) {
            int mid = headIndex + (endIndex - headIndex) / 2;
            if (key < params[mid]) {
                endIndex = mid - 1;
            } else if (key > params[mid]) {
                headIndex = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

}
