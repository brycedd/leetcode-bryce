package com.dd.dp;

/**
 * <strong>题目：</strong><br/>
 * K个逆序对数组<br/>
 * 给出两个整数n和k，找出所有包含从1到n的数字，且恰好拥有k个逆序对的不同的数组的个数。<br/>
 * 逆序对的定义如下：对于数组的第i个和第j个元素，如果满i&lt;j且a[i]>a[j]，则其为一个逆序对；否则不是。<br/>
 * 由于答案可能很大，只需要返回 答案 mod 109+ 7 的值。<br/>
 * <strong>示例：</strong><br/>
 * <blockquote><pre>
 *     输入: n = 3, k = 1
 *     输出: 2
 *     解释:
 *     数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
 * </pre></blockquote>
 *
 * @author Bryce_dd 2021/11/20 18:35
 */
public class L629 {
    public static void main(String[] args) {
        int i = kInversePairs(3, 1);
        System.out.println(i);
    }

    /**
     * <strong>思路：</strong><br/>
     * 先考虑dp[3][2]这种简单的情况。<br/>
     * 可以简单的推导出dp[4][2] = dp[3][2] + dp[3][1] + dp[3][0]:<br/>
     * 我们推导dp[4][2]的情况；相当与在dp[3][2]的基础上，数组中增加一个数字4，当这个数字插入在数组末端的时候，
     * 其获得两个逆序对的组合方式依旧是dp[3][2]种，但新加入数组的4，不仅可以放在末端，当其放在数组最前端的时候，
     * 4这个值便可新增最多个逆序对，也就是3对；通过这种简单情况，推导出dp[4][2]相对于dp[2][x]的值；<br/>
     * 通过上述公式，推导出最终公式:
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - i];
     *
     * @param n 数组长度
     * @param k 目标逆序对
     * @return 可完成目标逆序对的数组组合数
     */
    public static int kInversePairs(int n, int k) {
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (j >= i) dp[i][j] -= dp[i - 1][j - i];
                if (dp[i][j] < 0) dp[i][j] += MOD;
                dp[i][j] = dp[i][j] % MOD;
            }
        }
        return (int) dp[n][k];
    }
}
