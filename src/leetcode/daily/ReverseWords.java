package leetcode.daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: ReverseWords
 * @Description: 151. 翻转字符串里的单词
 * @Author: CheneyIn
 * @Date: 2020-04-10
 */
public class ReverseWords {
    /*
        给定一个字符串，逐个翻转字符串中的每个单词
        示例 1：
            输入: "the sky is blue"
            输出: "blue is sky the"
        示例 2：
            输入: "  hello world!  "
            输出: "world! hello"
            解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
        示例 3：
            输入: "a good   example"
            输出: "example good a"
            解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
        说明：
            无空格字符构成一个单词。
            输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
            如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

     */

    /**
     * 解题思路，
     * 1.通过Java语言特性，
     *   先将String进行split分割，
     * 2.然后再通过list进行反转，
     * 3.最终通过join进行连接
     *
     * @return
     */
    public static String reverseWords(String s) {
        // 这里通过正则表达式进行匹配分割，如果直接用" "去分割会出现问题，不能满足说明2
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("the sky is blue"));
    }

}
