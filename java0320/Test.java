package java0320;

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode{
//    char val;
//    TreeNode left;
//    TreeNode right;
//    public TreeNode(char val){
//        this.val = val;
//    }
//}
public class Test {
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队列
        queue.offer(root);
        while(true) {
            TreeNode cur = queue.poll();
            if(cur == null){
                break;
            }
            //出队列并访问此节点
            System.out.print(cur.val);
            //左右子树入队列
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

//    public static TreeNode bulid(){
//        TreeNode a = new TreeNode('A');
//        TreeNode b = new TreeNode('B');
//        TreeNode c = new TreeNode('C');
//        TreeNode d = new TreeNode('D');
//        TreeNode e = new TreeNode('E');
//        TreeNode f = new TreeNode('F');
//        TreeNode g = new TreeNode('G');
//        TreeNode h = new TreeNode('H');
//        TreeNode i = new TreeNode('I');
//
//        a.left = b;
//        a.right = c;
//        b.left = d;
//        c.left = e;
//        c.right = f;
//        d.left = g;
//        d.right = h;
//        e.left = i;
//
//        return a;
//
//    }
//    public static void main(String[] args) {
//        TreeNode root = bulid();
//        levelOrder(root);
//    }
}
