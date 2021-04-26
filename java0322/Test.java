package java0322;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test {
    //1、非递归先序遍历  使用栈实现
    public static void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.val+" ");
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //2、非递归中序遍历
    public static void inOrderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()){
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }
    }
    //3、非递归后序遍历
    public static void postOrderByLoop(TreeNode root){
          if(root == null){
              return;
          }
          Stack<TreeNode> stack = new Stack<>();
          TreeNode cur = root;
          TreeNode prev = null;
          while(true){
              while(cur != null){
                  stack.push(cur);
                  cur = cur.left;
              }
              if(stack.isEmpty()){
                  break;
              }
              TreeNode top = stack.peek();
              if(top.right == null || top.right == prev){
                  System.out.print(top.val+" ");
                  stack.pop();
                  prev = top;
              }else{
                  cur = top.right;
              }
          }
    }
    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        return a;
    }

    public static void main(String[] args) {
        TreeNode root = build();
        preOrderTraversal(root);
        System.out.println();
        inOrderByLoop(root);
        System.out.println();
        postOrderByLoop(root);
    }
}
