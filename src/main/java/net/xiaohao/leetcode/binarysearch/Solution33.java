package net.xiaohao.leetcode.binarysearch;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class Solution33 {

    public static void main(String[] args) {
        //先找出反转的index，在查找
        int[] nums = {1};
        Solution33 solution33 = new Solution33();
        int flipIndex = solution33.search(nums, -1);
        System.out.println(flipIndex);

    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int flipIndex = searchFlipIndex(nums, 0, nums.length - 1);
        if (flipIndex == -1) {
            return BinarySearchUtils.search(nums, target);
        }
        if (target <= nums[flipIndex] && target >= nums[0]) {
            return BinarySearchUtils.binarySearch(nums, target, 0, flipIndex);
        }
        if (target <= nums[nums.length - 1] && target >= nums[flipIndex + 1]) {
            return BinarySearchUtils.binarySearch(nums, target, flipIndex + 1, nums.length - 1);
        }
        return -1;
    }

    public int searchFlipIndex(int[] nums, int from, int to) {
        if (nums[to] > nums[from] || from == to) {
            return from - 1;
        }
        int middleIndex = (from + to) >> 1;
        if (middleIndex == 0
                || (nums[middleIndex] > nums[middleIndex + 1] && nums[middleIndex] > nums[middleIndex - 1])) {
            return middleIndex;
        }
        if (middleIndex == nums.length - 1
                || (nums[middleIndex] < nums[middleIndex + 1] && nums[middleIndex] < nums[middleIndex - 1])) {
            return middleIndex - 1;
        }
        if (nums[middleIndex] > nums[nums.length - 1]) {
            return searchFlipIndex(nums, middleIndex + 1, to);
        }
        if (nums[middleIndex] < nums[nums.length - 1]) {
            return searchFlipIndex(nums, from, middleIndex - 1);
        }
        return 0;
    }
}
