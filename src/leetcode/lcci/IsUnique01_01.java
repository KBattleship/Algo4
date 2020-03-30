package leetcode.lcci;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: IsUnique01_01
 * @Description: 面试题 01.01. 判定字符是否唯一
 * @Author: CheneyIn
 * @Date: 2020-03-21
 */
public class IsUnique01_01 {

    /*
        实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
        示例 1：
            输入: s = "leetcode"
            输出: false

        示例 2：
            输入: s = "abc"
            输出: true

        限制：
            0 <= len(s) <= 100
            如果你不使用额外的数据结构，会很加分。
     */
    public static boolean isUnique(String astr) {
        Set x = new HashSet();
        // 这里就用到了Java set数据结构去重的特性，时间复杂度为O(n)
        for (int i = 0; i < astr.length(); i++) {
            x.add(astr.charAt(i));
        }
        return x.size() == astr.length();
    }

    public static void main(String[] args) {
        String today = "today";
        String toolkit = "toolkit";
        assert isUnique(today);
        assert !isUnique(toolkit);
    }
}
