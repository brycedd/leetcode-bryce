package com.dd.leetcode;

/**
 * @author Bryce_dd 2022/7/18 22:41
 */
public class Simple {

    public static void main(String[] args) {
    }

    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * O(N)
     * O(N)
     */
    static class Solution876 {

        static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }


        }

        /**
         *
         * O(N)
         * O(N)
         */
        public static ListNode middleNode(ListNode head) {
            ListNode[] listNodes = new ListNode[100];
            int t = 0;
            while (head != null) {
                listNodes[t++] = head;
                head = head.next;
            }
            return listNodes[t / 2];
        }
        /**
         * O(N)
         * O(1)
         */
        static class Solution876_2 {
            public static ListNode middleNode(ListNode head) {
                var nodeSize = 0;
                var current = head;
                while (current != null) {
                    nodeSize++;
                    current = current.next;
                }
                // 当再次遍历到中间时终止
                var nodeMiddleSize = 0;
                current = head;
                while (nodeMiddleSize < nodeSize / 2) {
                    nodeMiddleSize++;
                    current = current.next;
                }
                return current;
            }
        }
    }


}
