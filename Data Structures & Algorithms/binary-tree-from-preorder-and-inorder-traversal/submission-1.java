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

class Solution {
    int pre=0;
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return preordermap(preorder,0,inorder.length-1);
    }
    private TreeNode preordermap(int[] preorder,int start,int end){
        if(start>end) return null;

        int rootval=preorder[pre++];
        TreeNode root=new TreeNode(rootval);

        int index=map.get(root.val);
        root.left=preordermap(preorder,start,index-1);
        root.right=preordermap(preorder,index+1,end);

        return root;
    }
}
