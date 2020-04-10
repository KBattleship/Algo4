package leetcode.daily;

import java.util.List;

/**
 * @ClassName: AddTwoNumbers
 * @Description: 2. 两数相加
 * @Author: CheneyIn
 * @Date: 2020-04-06
 */
public class AddTwoNumbers {
    /*
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preNode = new ListNode(0);
        ListNode currentNode = preNode;
        // 标记进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            int sum = i + j + carry;
            if (sum / 10 > 1) {
                // 两数之和需要进位
                carry = 1;
                sum = sum % 10;
            }else {
                carry = 0;
            }

            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry>0){
            currentNode.next = new ListNode(carry);
        }
        return preNode.next;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}