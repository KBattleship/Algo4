package leetcode.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: RightSideView
 * @Description: 199. 二叉树的右视图
 * @Author: CheneyIn
 * @Date: 2020-04-22
 */
public class RightSideView {
    /*
        给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

            示例:
            输入: [1,2,3,null,5,null,4]
            输出: [1, 3, 4]
            解释:

               1            <---
             /   \
            2     3         <---
             \     \
              5     4       <---
     */

    /*
        本题解题思路大概两种思路：广度搜索(BFS)与深度搜索(DFS).
        1.BFS
            因为是最右侧节点，每次记录下当前层最后一个节点，最终list就是所遍历出来的最右侧节点。
        2.DFS
            通过 根节点 --> 右子树 -->  左子树的顺序进行访问。
            这样可以保证每次访问都是最右侧树节点。

     */
    // 用于存储每层最右侧节点
    List<Integer> listResult = new ArrayList<>();

    public List<Integer> rightSideView_BFS(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        searchRightNode(root, 0);
        return listResult;
    }

    public void searchRightNode(TreeNode root, int depthIndex) {
        // 当树中无节点时停止深度搜索
        if (root == null) {
            return;
        }
        // 父节点
        if (depthIndex == listResult.size()) {
            listResult.add(root.val);
        }
        depthIndex++;
        searchRightNode(root.right, depthIndex);
        searchRightNode(root.left, depthIndex);
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}