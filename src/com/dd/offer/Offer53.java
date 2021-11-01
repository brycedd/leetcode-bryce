package com.dd.offer;

/**
 * @author Bryce_dd
 * @date 2021/11/1
 * 统计一个数字在排序数组中出现的次数。
 */
public class Offer53 {

    public static void main(String[] args) {
        int[] nums = {1,3,3,7,8,4,5,6,7,7,12,90};
        int search12 = search(nums, 12);
        int search3 = search(nums, 3);
        int search7 = search(nums, 7);
        int search60 = search(nums, 60);
        System.out.println(search12);
        System.out.println(search3);
        System.out.println(search7);
        System.out.println(search60);
    }

    /**
     * 二分法查找
     *
     * @param nums   传入数组
     * @param target 目标数字
     * @return 出现次数
     */
    public static int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx
                && rightIdx < nums.length
                && nums[leftIdx] == target
                && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
