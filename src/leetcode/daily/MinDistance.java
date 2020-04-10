package leetcode.daily;

/**
 * @ClassName: MinDistance
 * @Description: 72.编辑距离
 * @Author: CheneyIn
 * @Date: 2020-04-06
 */
public class MinDistance {

    /*
        给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

        你可以对一个单词进行如下三种操作：
        插入一个字符
        删除一个字符
        替换一个字符

        示例 1：

        输入：word1 = "horse", word2 = "ros"
        输出：3
        解释：
        horse -> rorse (将 'h' 替换为 'r')
        rorse -> rose (删除 'r')
        rose -> ros (删除 'e')

        示例 2：

        输入：word1 = "intention", word2 = "execution"
        输出：5
        解释：
        intention -> inention (删除 't')
        inention -> enention (将 'i' 替换为 'e')
        enention -> exention (将 'n' 替换为 'x')
        exention -> exection (将 'n' 替换为 'c')
        exection -> execution (插入 'u')

     */
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word2.charAt(j - 1) == word1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
                System.out.printf("dp[%d][%d] ==%d\n", i, j, dp[i][j]);
            }
        }
        return dp[len1][len2];
    }

    public static int minDistance2(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;

        int[] dp = new int[len2 + 1];
        for (int i = 0; i <= len2; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            int pre = dp[0];
            System.out.printf("pre==%d,", pre);
            for (int j = 0; j <= len2; j++) {
                if (j == 0) {
                    dp[j] = i;
                    System.out.printf("dp[%d]==%d\n", j, i);
                } else {
                    if (c1[i - 1] == c2[j - 1]) {
                        int temp = dp[j];
                        System.out.printf("dp[%d]==%d,", j, dp[j]);
                        dp[j] = pre;
                        System.out.printf("pre==%d,", pre);
                        pre = temp;
                        System.out.printf("temp==%d\n", temp);

                    } else {
                        int min = pre;
                        System.out.printf("min==%d,", min);
                        System.out.printf("dp[%d]==%d,", j - 1, dp[j - 1]);
                        min = dp[j - 1] < min ? dp[j - 1] : min;
                        System.out.printf("min==%d,", min);
                        System.out.printf("dp[%d]==%d,", j, dp[j]);
                        min = dp[j] < min ? dp[j] : min;
                        System.out.printf("min==%d,", min);
                        pre = dp[j];
                        System.out.printf("pre==%d,", pre);
                        dp[j] = min + 1;
                        System.out.printf("dp[%d]==%d\n", j, dp[j]);
                    }
                }
            }
        }
        return dp[len2];
    }


    public static void main(String[] args) {
        System.out.println(minDistance2("horse", "ros"));
        System.out.println(minDistance2("intention", "execution"));
    }
}
