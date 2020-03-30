package leetcode.daily;

import java.util.LinkedList;

/**
 * @ClassName: LastRemaining_62
 * @Description: 0, 1, , n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * @Author: CheneyIn
 * @Date: 2020-03-30
 */
public class LastRemaining_62 {

    /*
        62.圆圈中最后剩下的数字 -- 约瑟夫环问题：
            1. 直接使用链表进行解题 LinkedList
            2. 优化LinkedList防止超时
            3. 使用递归进行
     */

    public static int lastRemaining_1(int n, int m) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 将元素全部放到链表中去
        for (int i = 0; i < n; i++) {
            linkedList.add(i);
        }
        // 只要链表长度不为1就一直循环
        while (linkedList.size() != 1) {
            for (int j = 0; j < m; j++) {
                System.out.println("index-j:" + j);
                int prePoint = linkedList.pollFirst();
                System.out.println("first ele:" + prePoint);
                if (j != m - 1) {
                    System.out.println("remove ele:" + prePoint);
                    linkedList.add(prePoint);
                }
            }
        }
        return linkedList.pollFirst();
    }

    public static void main(String[] args) {
        // 解题思路1
         lastRemaining_1(5, 3);
         lastRemaining_1(10, 17);
        // 解题思路2
        //assert lastRemaining_1(5, 3) == 3;
        //assert lastRemaining_1(10, 17) == 2;
        // 解题思路3
        //assert lastRemaining_1(5, 3) == 3;
        //assert lastRemaining_1(10, 17) == 2;
    }
}
