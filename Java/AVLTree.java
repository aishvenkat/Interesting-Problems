public class AVLTree{
class TreeNode{
  int data;
  TreeNode left;
  TreeNode right;
  int height;
 
  public TreeNode(int data);
  {
    this.data = data;
    left = null;
    right = null;
    height = 1;
  }
}

TreeNode root = null;

public void insert(int data){

 TreeNode current = root;
 if(root == null)
  {
    root = new TreeNode(data);
  }
 else{
   if(data <= current.data){
    current.left = insert(current.left, data);
    
   }
   else
     current.right = insert(current.right, data);
 }

}
public TreeNode leftRotate(TreeNode node){
  TreeNode newRoot = node.right;
  TreeNode shiftChild = node.right.left;
  
  newRoot.left = node;
  node.right = shiftChild;

  newRoot.height = ((newRoot.left.height > newRoot.right.height) ? newRoot.left.height : newRoot.right.height) + 1;
  node.height = ((node.left.height > node.right.height) ? node.left.height : node.right.height) + 1;

  return newRoot;
}


public TreeNode insert(TreeNode node, int data){
if(node == null)
 return new TreeNode(data);
if(data <= node.data)
   node.left = insert(node.left,data);
else
  node.right = insert(node.right,data);
node.height = (((node.left.height > node.right.height)? node.left.height : node.right.height) + 1);

int balance = (node == null) ? 0 : (node.left.height - node.right.height);   

if((balance > 1) && (data < node.left.data))
 return rightRotate(node);
if((balance > 1) && (data > node.left.data)){
 node.left = leftRotate(node.left);
 return rightRotate(node);
 }
 if((balance < -1) && (data > node.right.data))
  return leftRotate(node);
 if((balance < -1) && (data < node.right.data)){
  node.right = rightRotate(node.right);
  return leftRotate(node);
 }
 return node;
}
}
