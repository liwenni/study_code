package java0317;


import java.util.ArrayList;
import java.util.List;

public class Level {
    public static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }
        helper(root,0);
        return  result;
    }
    public static void helper(TreeNode root,int level){
        if(level == result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left != null){
            helper(root.left,level + 1);
        }
        if(root.right != null){
            helper(root.right,level + 1);
        }
    }
}
