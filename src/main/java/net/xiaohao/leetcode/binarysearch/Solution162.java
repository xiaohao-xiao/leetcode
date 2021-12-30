package net.xiaohao.leetcode.binarysearch;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 */
public class Solution162 {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        Solution162 solution162 = new Solution162();
        System.out.println(solution162.search(nums));
    }

    public int search(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (right + left) >> 1;
            System.out.println(left + "," + middle + "," + right);
            if (middle == 0) {
                return nums[middle] > nums[middle + 1] ? middle : middle + 1;
            }
            if (middle == nums.length - 1) {
                return middle;
            }
            if (nums[middle] > nums[middle - 1]
                    && nums[middle] > nums[middle + 1]) {
                return middle;
            }
            if (nums[middle] < nums[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return 0;
    }
}
