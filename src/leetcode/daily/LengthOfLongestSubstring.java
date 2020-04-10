package leetcode.daily;

import java.util.HashSet;

/**
 * @ClassName: LengthOfLongestSubstring
 * @Description: 03.无重复字符的最长子串
 * @Author: CheneyIn
 * @Date: 2020-04-06
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.equals("")) return 0;
        if (1 == s.length()) return 1;
        char[] chars = s.toCharArray();
        int max = 0;
        //以i-1位置字符结尾的最长不重复字符串的开始索引（最左索引）
        int li = 0;
        //存储每个元素上一次出现的位置
        int[] preIndexs = new int[128];
        //初始化
        for (int i = 0; i < preIndexs.length; i++) {
            preIndexs[i] = -1;
        }
        //初始化
        preIndexs[chars[0]] = 0;   //如果不减 'a',可以用  int[] preIndexs = new int[128] ,该题不仅仅只有小写字母，故要使用128;
        for (int i = 1; i < chars.length; i++) {
            //i位置元素上一次出现的位置
            Integer pi = preIndexs[chars[i]];
            if (pi >= li){
                li = pi +1;
            }
            //存储这个字符出现的位置
            preIndexs[chars[i]] = i;
            int len = i - li+1;
            if (len > max)max = len;
        }

        return max;
    }
    public static int lengthOfLongestSubstring(String s) {
        int lengthWindow = 1;
        int max = 1;
        int index = 0;
        if (s.length() <= 0) {
            return 0;
        }
        while (index + lengthWindow <= s.length()) {
            String subString = s.substring(index, index + lengthWindow);
            HashSet<Character> set = new HashSet<>();
            boolean isBool = false;
            for (int i = 0; i < subString.length(); i++) {
                if (!set.add(subString.charAt(i))) {
                    index ++;
                    lengthWindow = 1;
                    isBool = true;
                    break;
                }
            }

            if (!isBool) {
                if (lengthWindow == s.length())
                    return lengthWindow;
                lengthWindow++;
            }

            max = max < lengthWindow ? lengthWindow - 1 : max;

        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("aa"));
        System.out.println(lengthOfLongestSubstring("abbabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
