package net.xiaohao.leetcode.array;

public class MatrixSearch {


    private static boolean search(int target, int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int x = searchX(target, matrix, 0, matrix.length - 1);
        if (x == -11) {
            return true;
        }

        System.out.println("x:" + x);
        return true;
    }

    private static int searchX(int target, int[][] matrix, int from, int end) {
        System.out.println(from + "," + end);
        if (from + 1 == end) {
            if (matrix[from][matrix[0].length - 1] >= target) {
                return from;
            }
            return end;
        }
        int middleX = (end + from) >> 1;
        System.out.println(middleX);
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
                {1, 3, 5, 7, 9},
                {11, 12, 13, 14, 15},
                {17, 20, 23, 29, 31},
                {32, 36, 39, 40, 58}
        };
        System.out.println(search(60, matrix));
    }
}
