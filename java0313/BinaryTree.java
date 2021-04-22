package java0313;

class Node{
    String val;
    Node left;
    Node right;

    public Node(String val){
        this.val = val;
    }
}


public class BinaryTree {
    public static Node build(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    //1、先序遍历
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        //先遍历根节点
        System.out.print(root.val);
        //再递归遍历左子树
        preOrder(root.left);
        //最后递归遍历右子树
        preOrder(root.right);

    }
    //2、中序遍历
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        //先递归遍历左子树
        inOrder(root.left);
        //再处理根节点
        System.out.print(root.val);
        //最后递归遍历右子树
        inOrder(root.right);
    }

    //3、后序遍历
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        //先遍历左子树
        postOrder(root.left);
        //再遍历右子树
        postOrder(root.right);
        //最后处理根节点
        System.out.print(root.val);
    }

    //4、求节点个数
    public static int NodeNumber(Node root){
        if(root == null){
            return 0;
        }
        return 1 + NodeNumber(root.left) + NodeNumber(root.right);

    }

    //5、求叶子节点的个数
    public static int leafNumber(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leafNumber(root.left) + leafNumber(root.right);
    }

    //6、求第k层节点的个数
    public static int kLevelNumber(Node root,int k){
        if(root == null || k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return kLevelNumber(root.left,k - 1) + kLevelNumber(root.right,k -1);
    }

    //7.查找节点
    public static Node find(Node root,String toFind){
        if(root == null){
            return null;
        }
        if(root.val.equals(toFind)){
            return root;
        }
        Node result = find(root.left,toFind);

        if(result != null){
            return result;
        }
        //若result为空，则说明在左子树中没有找到，
        // 则需递归遍历右子树
        return find(root.right,toFind);
    }

    //8、求解树的高度
    public static int Height(Node root){
        if(root == null){
            return 0;
        }
//        if(root.left == null && root.right == null){
//            return 1;
//        }
        int leftHeight = Height(root.left);
        int rightHeight = Height(root.right);
        return 1 +( leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    //9、

    public static void main(String[] args) {
        Node root = build();
//        System.out.print("先序遍历：");
//        preOrder(root);
//        System.out.println();
//        System.out.print("中序遍历：");
//        inOrder(root);
//        System.out.println();
//        System.out.print("后序遍历：");
//        postOrder(root);
//        System.out.println();
//        System.out.print("节点个数：");
//        System.out.println(NodeNumber(root));
//        System.out.print("叶子节点的个数：");
//        System.out.println(leafNumber(root));
//        System.out.print("第4层节点的个数：");
//        System.out.println(kLevelNumber(root,4));
        System.out.println("树的高度：");
        System.out.println(Height(root));

    }
}
