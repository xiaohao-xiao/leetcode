package net.xiaohao.leetcode.binarysearch;

import java.util.Objects;

/**
 * 二分查找
 */
public class BinarySearchUtils {

    private BinarySearchUtils() {
    }

    public static int search(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            throw new IllegalArgumentException("数组不能为空!");
        }
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] nums, int target, int from, int to) {
        if (nums[from] > target || nums[to] < target) {
            return -1;
        }
        int middleIndex = (to + from) >>> 1;
        if ((from == to && nums[middleIndex] != target)) {
            return -1;
        }
        if (nums[middleIndex] == target) {
            return middleIndex;
        }
        if (nums[middleIndex] > target && middleIndex > 0) {
            return binarySearch(nums, target, from, middleIndex - 1);
        }
        if (nums[middleIndex] < target && middleIndex < nums.length - 1) {
            return binarySearch(nums, target, middleIndex + 1, to);
        }
        return -1;
    }
}
