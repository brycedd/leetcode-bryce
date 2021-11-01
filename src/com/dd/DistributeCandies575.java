package com.dd;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bryce_dd
 * @date 2021/11/1
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * <p>
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * <p>
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DistributeCandies575 {

    public static void main(String[] args) {
        int[] a = {1,1,2,3,3,4,5,7,7,10};
        System.out.println(distributeCandies(a));
    }

    /**
     * 时间复杂度：O(n)，其中 n 是数组 candies 的长度。
     * 空间复杂度：O(n)。哈希表需要 O(n) 的空间。
     */
    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (Integer candy : candyType) {
            set.add(candy);
        }
        return Math.min(candyType.length / 2, set.size());
    }
}