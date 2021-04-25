//package java0320;
//
//
//import java.util.Scanner;
//
//class TreeNode{
//    char val;
//    TreeNode left;
//    TreeNode right;
//
//    public TreeNode(char val){
//        this.val = val;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //循环处理多组输入
//        while(scanner.hasNext()){
//            String line = scanner.next();
//            //创建节点
//            TreeNode root = build(line);
//            //中序遍历
//            inOrder(root);
//            //每个输出结果占一行
//            System.out.println();
//        }
//    }
//    //创建成员变量，记录节点遍历创建的位置
//    public static int index = 0;
//    //创建节点
//    public static TreeNode build(String line){
//        char ch = line.charAt(index);
//        if(ch == '#'){
//            return null;
//        }
//        //先序创建节点
//        //创建根节点
//        TreeNode root = new TreeNode(ch);
//        index++;// index 往后移动一位
//        //递归创建左节点
//        root.left = build(line);
//        index++;// index 再往后移动一位
//        //递归创建右节点
//        root.right = build(line);
//
//        return root;
//    }
//
//    //中序遍历
//    public static void inOrder(TreeNode root){
//        if(root == null){
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.val+" ");//输出格式符合要求 节点中间加一个空格
//        inOrder(root.right);
//    }
//
//}
