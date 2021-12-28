package net.xiaohao.leetcode.array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int index = binarySearch(target, nums, 0, nums.length - 1);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int begin = index;
        while (begin > 0 && nums[begin - 1] == target) {
            begin--;
        }
        int end = index;
        while (end < nums.length - 1 && nums[end + 1] == target) {
            end++;
        }
        return new int[]{begin, end};

    }

    private int binarySearch(int target, int[] array, int from, int end) {
        int middleIndex = (end + from) >> 1;

        if (from == end && array[middleIndex] != target) {
            return -1;
        }

        if (array[middleIndex] == target) {
            return middleIndex;
        }
        if (array[middleIndex] > target && middleIndex > 0) {
            return binarySearch(target, array, from, middleIndex - 1);
        }
        if (array[middleIndex] < target && middleIndex < array.length - 1) {
            return binarySearch(target, array, middleIndex + 1, end);
        }
        return -1;
    }
}
