/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        shelper(root,sb);
        return sb.toString();
    }
    private void shelper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#, ");
            return;
        }
        sb.append(root.val).append(", ");
        shelper(root.left,sb);
        shelper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes=data.split(", ");
        int[] index=new int[1];
        return dhelper(nodes,index);
    }
    private TreeNode dhelper(String[] data,int[] index){
        if(data[index[0]].equals("#")){
            index[0]++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(data[index[0]++]));
        root.left=dhelper(data,index);
        root.right=dhelper(data,index);

        return root;
    }
}
