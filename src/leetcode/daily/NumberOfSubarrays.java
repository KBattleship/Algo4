package leetcode.daily;

/**
 * @ClassName: NumberOfSubarrays
 * @Description: 1248. 统计「优美子数组」
 * @Author: CheneyIn
 * @Date: 2020-04-21
 */
public class NumberOfSubarrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1},3));
        System.out.println(numberOfSubarrays(new int[]{2,4,6},1));
        System.out.println(numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2));
    }
}
