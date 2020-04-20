package leetcode.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: NumIslands
 * @Description: 200.岛屿数量
 * @Author: CheneyIn
 * @Date: 2020-04-20
 */
public class NumIslands {

    /*
        此题肯定从广度、深度搜索两种思维进行入考虑。
        广度搜索：
            先通过扫描整个网格，如果位置是1就加入队列，开始广度搜索。
            在广度搜索过程中，每当搜索到1都会重新标记为0，标识已被搜索过，并且给次数进行加一。循环队列，直到队列为空。
            最终，次数将为岛屿个数。
     */
    public int numIslands(char[][] grid) {
        // 先判断网格不为空
        int m = grid.length;
        if (grid == null || m == 0) {
            return 0;
        }

        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; ++i) {

            for (int j = 0; j < n; ++j) {
                // 判断当前值是否为1
                if (grid[i][j] == '1') {
                    ++num;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    //
                    queue.add(i * n + j);
                    while (!queue.isEmpty()) {
                        int index = queue.remove();
                        int x = index / n;
                        int y = index % n;
                        // 遍历上下左右四个方向
                        // 左侧
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            queue.add((x - 1) * n + y);
                            grid[x - 1][y] = '0';
                        }
                        // 右侧
                        if (x + 1 < m && grid[x + 1][y] == '1') {
                            queue.add((x + 1) * n + y);
                            grid[x + 1][y] = '0';
                        }
                        // 上方
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            queue.add(x * n + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        // 下方
                        if (y + 1 < n && grid[x][y + 1] == '1') {
                            queue.add(x * n + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return num;
    }
}
