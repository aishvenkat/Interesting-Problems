import java.util.*;
class constructBinaryTree{
class BinaryTree{
  int data;
  BinaryTree left;
  BinaryTree right;
  public BinaryTree(int data){
    this.data = data;
    left = null;
    right = null;
  }
}

BinaryTree root = null;
public void printLevelOrder(BinaryTree node){
 
 Queue<BinaryTree> LevelOrderQueue = new LinkedList<BinaryTree>();
 LevelOrderQueue.add(node);
 
 int currentLevel = 1;
 int nextLevel = 0;
 
 while(!LevelOrderQueue.isEmpty()){
  BinaryTree currentTree = LevelOrderQueue.poll();
  if(currentTree == null) break;
  currentLevel--;
  System.out.print(currentTree.data);
   
   //Left
   if(currentTree.left != null){
   	LevelOrderQueue.add(currentTree.left);
   	nextLevel++;
   }
  
   //Right
   if(currentTree.right != null){
   	LevelOrderQueue.add(currentTree.right);
   	nextLevel++;
   }
  if(currentLevel == 0){
   System.out.println(); //Level completed;
   currentLevel = nextLevel;
   nextLevel = 0;
   }
  }
}
static String postOrder;

public void constructTreeWithPostAndInorder(String postOrder, String inOrder){
    this.postOrder = postOrder;
    this.root = constructTree(inOrder);
    printLevelOrder(root);
}
public BinaryTree constructTree( String inOrder){
 
 if(inOrder == null)
   return null;
 int root = Character.getNumericValue(postOrder.charAt(postOrder.length()-1));
 int rootIndex = inOrder.indexOf(postOrder.charAt(postOrder.length()-1));
 
 String leftSubTree =  (rootIndex == 0) ? null:inOrder.substring(0,rootIndex);
 String rightSubTree = ((rootIndex+1) >= inOrder.length())? null:inOrder.substring(rootIndex+1,inOrder.length());
 
 BinaryTree node = new BinaryTree(root);
 
 postOrder = postOrder.substring(0,postOrder.length()-1);
 node.right = constructTree(rightSubTree);
 node.left = constructTree(leftSubTree);
 
 return node;
}
 public static void main(String[] args){
   constructBinaryTree bt = new constructBinaryTree();
   bt.constructTreeWithPostAndInorder("495286731","429518637");

 }
}
