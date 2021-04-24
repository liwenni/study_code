//package java0317;
//
//import java.util.Scanner;
//
//public class CreateTree {
//    public static class TreeNode{
//        public char val;
//        public TreeNode left;
//        public TreeNode right;
//
//        public TreeNode(char val){
//            this.val = val;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //多组输入循环处理
//        while(scanner.hasNext()){
//            String line = scanner.next();
//            //创建节点
//            TreeNode root = build(line);
//            //中序遍历
//            inOrder(root);
//            System.out.println();
//        }
//    }
//    //创建成员变量index，记录build执行过程中，字符串被处理到了第几个字符。
//    public static int index = 0;
//    public static TreeNode build(String input){
//        char ch = input.charAt(index);
//        if(ch == '#'){
//            return null;
//        }
//        //ch不为空，即可创建节点
//        TreeNode root = new TreeNode(ch);
//        index++;//继续处理新建下一个节点
//        root.left = build(input);
//        index++;
//        root.right = build(input);
//        return root;
//    }
//    public static void inOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.val + " ");
//        inOrder(root.right);
//    }
//}
