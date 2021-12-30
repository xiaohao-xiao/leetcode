package net.xiaohao.leetcode.binarysearch;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 */
public class MatrixSearch {


    private boolean search(int target, int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0
                || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {
            return false;
        }
        int x = searchX(target, matrix, 0, matrix.length - 1);
        if (x == -1) {
            return false;
        } else if (x == -11) {
            return true;
        }
        return binarySearch(target, matrix[x], 0, matrix[x].length - 1);
    }

    private int searchX(int target, int[][] matrix, int from, int end) {
        if (from == end) {
            return from;
        }
        if (from + 1 == end) {
            if (matrix[from][matrix[0].length - 1] >= target) {
                return from;
            } else if (matrix[end][matrix[0].length - 1] < target) {
                return -1;
            }
            return end;
        }
        int middleX = (end + from) >> 1;
        if (matrix[middleX][matrix[0].length - 1] == target) {
            return -11;
        }
        if (matrix[middleX][matrix[0].length - 1] <= target) {
            return searchX(target, matrix, middleX, end);
        }
        if (matrix[middleX][matrix[0].length - 1] > target) {
            return searchX(target, matrix, from, middleX);
        }
        return end;
    }

    private boolean binarySearch(int target, int[] array, int from, int end) {
        int middleIndex = (end + from) >> 1;

        if (from == end && array[middleIndex] != target) {
            return false;
        }
        if (target < array[from]) {
            return false;
        }
        if (array[middleIndex] == target) {
            return true;
        }
        if (array[middleIndex] > target && middleIndex > 0) {
            return binarySearch(target, array, from, middleIndex - 1);
        }
        if (array[middleIndex] < target && middleIndex < array.length - 1) {
            return binarySearch(target, array, middleIndex + 1, end);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        MatrixSearch search = new MatrixSearch();
        System.out.println(search.search(13, matrix));
    }
}
