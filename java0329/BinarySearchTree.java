package java0329;


class BinaryNode{
    public int key;
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int key,int value) {
        this.key = key;
        this.value = value;
    }
}


public class BinarySearchTree {
    private BinaryNode root = null;

    //1.查找节点
    public Integer get(int key){
        //创建一个引用cur 从root出发
        BinaryNode cur = root;
        while(cur != null){
            if(key < cur.key ){
                cur = cur.left;
            }else if(key > cur.key){
                cur = cur.right;
            }else{
                return cur.value;
            }
        }
        return null;
    }
    //2.插入节点
    public void put(int key,int value){
        if(root == null){
            root = new BinaryNode(key,value);
            return;
        }
        //先找到要插入节点的位置
        BinaryNode cur = root;
        BinaryNode parent = null;
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                cur.value = value;
                return;
            }
        }
        BinaryNode newNode = new BinaryNode(key,value);
        if(key < parent.key){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
    }
    //3.删除节点
    public void remove(int key){
        //先查找待删除节点的位置
        BinaryNode cur = root;
        BinaryNode parent = null;
        while(cur != null){
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }else{
                removeNode(parent,cur);
                return;
            }
        }
    }
    private void removeNode(BinaryNode parent,BinaryNode cur){

        if(cur.left == null){
            //1.待删除节点的左子树为空
            if(cur == root){
                //1.1待删除节点是根节点
                root = cur.right;
            }else if(cur == parent.left){
                //1.2待删除节点不是根节点，是父节点的左节点
                parent.left = cur.right;
            }else if(cur == parent.right){
                //1.3待删除节点不是根节点，是父节点的右节点
                parent.right = cur.right;
            }
        }else if(cur.right == null){
            //2.待删除节点的右子树为空
            if(cur == root){
                //2.1待删除节点是根节点
                root = cur.left;
            }else if(cur == parent.left){
                //2.2待删除节点是父节点的左节点
                parent.left = cur.left;
            }else if(cur == parent.right){
                //2.3待删除节点是父节点的右节点
                parent.right = cur.left;
            }
        }else{
            //3.待删除节点的左右子树都不为空
            //需在其右子树中找一个最小节点作为替罪羊节点
            //将替罪羊节点复制给待删除节点，再将原替罪养节点删除
            BinaryNode goat = cur.right;
            BinaryNode goatParent = null;
            while(goat.left != null){
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            cur.value = goat.value;

            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }else{
                goatParent.right = goat.right;
            }
        }
    }
}
