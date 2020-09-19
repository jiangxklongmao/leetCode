package offer;

public class Offer_04 {
    //region 剑指 Offer 04. 二维数组中的查找

    /*在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

             

    示例:

    现有矩阵 matrix 如下：

            [
            [1,   4,  7, 11, 15],
            [2,   5,  8, 12, 19],
            [3,   6,  9, 16, 22],
            [10, 13, 14, 17, 24],
            [18, 21, 23, 26, 30]
            ]
    给定 target = 5，返回 true。

    给定 target = 20，返回 false。*/

    //endregion

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{-5}};

        System.out.println("find = " + findNumberIn2DArray(matrix, -10));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int line = 0, column = matrix[0].length - 1;

        while (line < matrix.length && column >= 0) {
            if (matrix[line][column] == target) {
                return true;
            }
            if (matrix[line][column] > target) {
                column--;
            } else if (matrix[line][column] < target) {
                line++;
            }
        }
        return false;
    }

}
