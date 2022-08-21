package com.dd.leetcode;

/**
 * @author Bryce_dd 2022/7/18 23:10
 */
public class Middle {

    public static void main(String[] args) {
        System.out.println(Solution396.maxRotateFunction(new int[]{4,3,2,6,7}));
    }

    /**
     * 给定一个长度为 n 的整数数组nums。
     *
     * 假设arr_k是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
     *
     * F(k) = 0 * arr_k[0] + 1 * arr_k[1] + ... + (n - 1) * arr_k[n - 1]
     * 返回F(0), F(1), ..., F(n-1)中的最大值。
     *
     * 生成的测试用例让答案符合32 位 整数。
     */
    static class Solution396 {
        /**
         * https://leetcode.cn/problems/rotate-function/solution/by-ac_oier-sxbi/
         */
        public static int maxRotateFunction(int[] nums) {
            int sum = 0, f = 0, n = nums.length, ans = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                f += i * nums[i]; // 计算F(0)
            }
            ans = f;
            for (int i = 1; i < n; i++) { // 迭代计算F(i)
                f = f + sum - n * nums[n-i]; // F(i) = F(i-1) + sum - n * A(n-i)
                ans = Math.max(ans, f);
            }
            return ans;
        }
    }
}
