package java0317;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Test {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth,rightDepth);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }


    public boolean isMirror(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isMirror(root1.left,root2.right) && isMirror(root1.right,root2.left);
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.offer(root);
        while(true){
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            System.out.print(cur.val);
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
    public static TreeNode bulid(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.left = i;

        return a;

    }



    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        //分两个阶段来判定
        boolean isLevel = true;//为true说明处在第一个阶段
        //层序遍历，用队列来实现
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点入队列
        queue.offer(root);
        while (true) {
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            if (isLevel) {
                //第一阶段
                if (cur.left != null && cur.right != null){
                    //当前节点左右子树均不为空，则入队列，继续进行遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left != null && cur.left == null ){
                    //当前节点左子树不为空，右子树为空，进入第二阶段继续判断
                    isLevel = false;
                    //将左子树入队列
                    queue.offer(cur.left);
                }else if(cur.left == null && cur.right != null){
                    //当前节点左子树为空，右子树不为空，不是完全二叉树
                    return false;
                }else{
                    //当前左右子树均为空，进入第二阶段继续判断
                    isLevel = false;
                }
            } else {
                //第二阶段
                if(cur.left != null || cur.right != null){
                    return false;
                }
            }

        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = bulid();
        //levelOrder(root);
        System.out.println(isCompleteTree(root));
    }
}
