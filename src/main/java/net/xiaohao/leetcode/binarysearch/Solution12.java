package net.xiaohao.leetcode.binarysearch;

import java.util.*;

public class Solution12 {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int[] nums = {1, 1, -2};
        Solution12 solution12 = new Solution12();
        List<List<Integer>> list = solution12.threeSum(nums);
        long t2 = System.currentTimeMillis();
        System.out.println("耗时：" + (t2 - t1));
        list.forEach(e -> {
            e.forEach(value -> System.out.print(value + ","));
            System.out.println("\r\n--------------------------------");
        });
    }

    public List<List<Integer>> threeSum(int[] nums) {
        long t1 = System.currentTimeMillis();
        Arrays.sort(nums);
        long t2 = System.currentTimeMillis();
        System.out.println("排序耗时：" + (t2 - t1));
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0 || nums[0] > 0 || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int index1 = 0, index2 = 1;
        while (nums[index1] <= 0
                && index1 < index2
                && index2 < nums.length - 1) {
            System.out.println("index1:" + index1 + ",index2:" + index2);
            String key = nums[index1] + "|" + nums[index2];
            int twoSum = nums[index1] + nums[index2];
            if (twoSum + nums[nums.length - 1] < 0 || set.contains(key)) {
                if (index2 < nums.length - 2) {
                    index2++;
                    continue;
                }
                index1++;
                index2 = index1 + 1;
                continue;
            }
            if (twoSum > 0
                    || (twoSum == 0 && nums[index2 + 1] > 0)) {
                index1++;
                index2 = index1 + 1;
                continue;
            }
            System.out.println("查找" + (-nums[index1] - nums[index2]) + "......");
            int index3 = binarySearch0(nums, index2 + 1, nums.length, -nums[index1] - nums[index2]);
            if (index3 >= 0) {
                System.out.println("找到了!");
                set.add(key);
                list.add(Arrays.asList(nums[index1], nums[index2], nums[index3]));
            }
            if (index2 < nums.length - 2) {
                index2++;
                continue;
            }
            index1++;
            index2 = index1 + 1;
        }
        return list;
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        System.out.println("key:" + key + "--->fromIndex:" + fromIndex + ",toIndex:" + toIndex);
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

}
