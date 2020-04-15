package leetcode.daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: UpdateMatrix
 * @Description: 542.01矩阵
 * @Author: CheneyIn
 * @Date: 2020-04-15
 */
public class UpdateMatrix {

    public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        // 首先遍历出矩阵中所有0的节点，并将坐标放入队列，
        // 否则其他非0数进行标记标识当前未访问，防止超时
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        // 定义四个方向距离
        int[] mx = new int[]{-1, 1, 0, 0};
        int[] my = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            // 获取0节点坐标值
            int[] point = queue.poll();
            // x坐标
            int x = point[0];
            // y坐标
            int y = point[1];

            // 遍历四个方向
            for (int i = 0; i < 4; i++) {
                int x1 = x + mx[i];
                int y1 = y + my[i];
                if (x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && matrix[x1][y1] == -1) {
                    // 如果值为-1标识未访问过，将进行加1标记已访问
                    matrix[x1][y1] = matrix[x][y] + 1;
                    queue.offer(new int[]{x1, y1});
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] x = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        for (int[] i : updateMatrix(x)) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("");
        int[][] y = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        for (int[] i : updateMatrix(y)) {
            System.out.println(Arrays.toString(i));
        }
    }
}
