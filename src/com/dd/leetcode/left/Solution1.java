package com.dd.leetcode.left;

import java.util.ArrayList;

/**
 * @author Bryce_dd 2022/7/19 22:53
 *
 * 搜索二叉树（BST）
 */
public class Solution1 {

    public static void main(String[] args) {
        final int[] postArr = {2, 4, 3, 6, 8, 7, 5};
        final Node node = process2(postArr, 0, postArr.length - 1);
        System.out.println(node);
    }

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    /**
     * O(N平方)
     */
    public static Node process1(int[] posArr, int l, int r) {
        // 此处避免全右节点导致 l > r 的情况存在
        if (l > r) {
            return null;
        }
        Node head = new Node(posArr[r]);
        // 若只存在一个元素了，那一定是head
        if (l == r) {
            return head;
        }
        // 不止有一个元素，找到比头元素小的，最右边的那个元素
        // l index 的元素已经作为头取出
        int m = l - 1; // 防止仅有左树没有右/左树的情况
        for (int i = l; i < r; i++) { // 这个地方可以用二分优化
            if (posArr[i] < posArr[r]) {
                // 找出比头小的最后一个元素的位置
                m = i;
            }
        }
        // 分别将本次处理的 head 左树和右树 再继续进行递归
        head.left = process1(posArr, l, m);
        head.right = process1(posArr, m + 1, r - 1);
        return head;
    }

    /**
     * O(n*log_2N)
     */
    public static Node process2(int[] posArr, int l, int r) {
        if (l > r) {
            return null;
        }
        Node head = new Node(posArr[r]);
        if (l == r) {
            return head;
        }
        int m = l - 1;
        int left = l;
        int right = r -1;
        while (left <= right) {
            // mid = (left + right) / 2  这样算，可能会因为两个int 数相加溢出
            // mid = left + (right - left) / 2
            // mid = left + (right - left) >> 1
            int mid = left + ((right - left) >> 1);
            if (posArr[mid] < posArr[r]) {
                m = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 分别将本次处理的 head 左树和右树 再继续进行递归
        head.left = process1(posArr, l, m);
        head.right = process1(posArr, m + 1, r - 1);
        return head;
    }

    // 创建一个搜索二叉树
    public static Node generateRandomBST(int min, int max, int n) {
        if (min > max) {
            return null;
        }
        return createTree(min, max, 1, n);
    }

    private static Node createTree(int min, int max, int level, int n) {
        if (min > max || level > n) {
            return null;
        }
        final Node head = new Node(random(min, max));
        head.left = createTree(min, head.value - 1, level + 1, n);
        head.right = createTree(head.value + 1, max, level + 1, n);
        return head;
    }

    private static int random(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }

    // 遍历搜索二叉树
    public static int[] getBstPosArray(Node head) {
        final ArrayList<Integer> posList = new ArrayList<>();
        pos(head, posList);
        int[] ans = new int[posList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = posList.get(i);
        }
        return ans;
    }

    private static void pos(Node head, ArrayList<Integer> posList) {
        if (head != null) {
            pos(head.left, posList);
            pos(head.right, posList);
            posList.add(head.value);
        }
    }


}
