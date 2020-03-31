package leetcode.daily;

/**
 * @ClassName: ClimbStairs_70
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @Author: CheneyIn
 * @Date: 2020-03-31
 */
public class ClimbStairs_70 {
    /*
        1.暴力解法
        LeetCode 会报超时
     */
    private static int climbStairs1(int n) {
        if (n <= 2) return n;
        if (n == 0) return 1;
        int r = climbStairs1(n - 1) + climbStairs1(n - 2);
        System.out.println(r);
        return r;
    }


    /*
        2.记忆法优化递归:仅执行N次，执行过得结果完全可以通过数组取出
     */
    private static int climbStairs2(int n) {
        int[] intArray = new int[n + 1];
        return climbStairs2_2(n, intArray);
    }

    private static int climbStairs2_2(int n, int[] intArray) {
        if (n <= 2) intArray[n] = n;
        if (n == 0) intArray[n] = 1;
        if (intArray[n] <= 0) {
            intArray[n] = climbStairs2_2(n - 1, intArray) + climbStairs2_2(n - 2, intArray);
        }
        return intArray[n];
    }

    public static void main(String[] args) {
        assert climbStairs1(6)==13;
        assert climbStairs2(6)==13;
    }
}
