package leetcode.daily;

/**
 * @ClassName: ReverseInteger
 * @Description: 7.整数反转
 * @Author: CheneyIn
 * @Date: 2020-04-10
 */
public class ReverseInteger {
    /*
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
        示例 1:
            输入: 123
            输出: 321
        实例 2:
            输入: -123
            输出: -321
        示例 3:
            输入: 120
            输出: 21
        注意:
            假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
            请根据这个假设，如果反转后整数溢出那么就返回 0
     */
    private static int reverseInteger(int x) {
        int reverse = 0;
        while (x != 0) {
            int remainder = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && remainder > 7)) return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && remainder < -8)) return 0;
            reverse = reverse * 10 + remainder;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-321));
        System.out.println(reverseInteger(120));
    }
}
