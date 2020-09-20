package offer;

public class Offer_13 {

    //region 剑指 Offer 13. 机器人的运动范围
    /*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

             

    示例 1：

    输入：m = 2, n = 3, k = 1
    输出：3
    示例 2：

    输入：m = 3, n = 1, k = 0
    输出：1
    提示：

            1 <= n,m <= 100
            0 <= k <= 20*/
    //endregion

    public static void main(String[] args) {
        int move = movingCount(16, 8, 4);
        System.out.println(move);
    }


    public static int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(visit, m, n, 0, 0, k);
    }

    private static int dfs(boolean[][] visit, int m, int n, int row, int column, int k) {
        if (row < 0 || row >= m || column < 0 || column >= n || visit[row][column] || !isValid(row, column, k)) {
            return 0;
        }
        visit[row][column] = true;
        return 1 + dfs(visit, m, n, row, column + 1, k) + dfs(visit, m, n, row + 1, column, k);
    }

    private static boolean isValid(int i, int j, int k) {
        int rowSum = 0, columnSum = 0;
        while (i != 0) {
            rowSum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            columnSum += j % 10;
            j /= 10;
        }

        return rowSum + columnSum <= k;
    }

}
