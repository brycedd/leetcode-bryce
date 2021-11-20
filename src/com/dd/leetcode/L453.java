package com.dd.leetcode;

import java.util.Arrays;

/**
 * <strong>题目：</strong><br/>
 * MinimumMovesToEqualArrayElements<br/>
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。<br/>
 * 返回让数组所有元素相等的最小操作次数。
 *
 * @author Bryce_dd
 */
public class L453 {

    public static void main(String[] args) {
        int[] nums = {3, 7, 5, 1, 0};
        System.out.println(minMoves(nums));
        System.out.println(minMoves2(nums));
    }

    /**
     * <strong>思路1：</strong><br/>
     * 若最终目的是是所有数组元素相同， <br/>
     * 及差值为0；每次(n-1)个元素 +1 的操作，相当于每次一个元素 -1 的操作；<br/>
     * 那么，因为每次只能操作一个数字，则所有元素和最小值的差值之和，为最小操作次数；
     *
     * @param nums 数组
     * @return 操作最小数
     */
    public static int minMoves(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int result = 0;
        for (int num : nums) {
            result += num - min;
        }
        return result;
    }


    /**
     * <strong>思路2：</strong><br/>
     * 假定变换后值为 x ，n为数组长度，min为最小值，sum为原始数组求和；<br/>
     * 则等式成立： xn = (x - min)(n - 1) + sum;<br/>
     * 等式变换： x = min(1-n) + sum<br/>
     * 则变换次数为：x - min<br/>
     *
     * @param nums 数组
     * @return 操作最小数
     */
    public static int minMoves2(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = Arrays.stream(nums).sum();
        return min * (1 - nums.length) + sum - min;

    }
}
