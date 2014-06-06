using System;
using System.Collections.Generic;

public class SortByAVL{

public class BinaryTree{
 public int data {get;set;}
 public BinaryTree left {get;set;}
 public BinaryTree right {get;set;}
 public int height {get;set;}
 public BinaryTree(int data){
  this.data = data;
  left = null;
  right = null;
  height = 1;
 }

}
public class AVL{
BinaryTree root = null;

private int getHeight(BinaryTree node)
{
  if(node == null)
   return 0;
  else 
    return node.height;
}


private BinaryTree leftRotate(BinaryTree node){
 BinaryTree newRoot = node.right;
 BinaryTree tempChild = newRoot.left;

 newRoot.left = node;
 node.right = tempChild;

 node.height = (((getHeight(node.left) > getHeight(node.right)) ? getHeight(node.left) : getHeight(node.right)) + 1);
 newRoot.height = (((getHeight(newRoot.left) > getHeight(newRoot.right)) ? getHeight(newRoot.left) : getHeight(newRoot.right)) + 1);

 return newRoot;
}


private BinaryTree rightRotate(BinaryTree node){
 BinaryTree newRoot = node.left;
 BinaryTree tempChild = newRoot.right;

 newRoot.right = node;
 node.left = tempChild;

 node.height = (((getHeight(node.left) > getHeight(node.right)) ? getHeight(node.left) : getHeight(node.right)) + 1);
 newRoot.height = (((getHeight(newRoot.left) > getHeight(newRoot.right)) ? getHeight(newRoot.left) : getHeight(newRoot.right)) + 1);

 return newRoot;
 
}

//Public insert call
public void insertNode(int data){
 if(root == null)
   root = new BinaryTree(data);
 else{
   root = insert(root, data);
 }
}


private BinaryTree insert(BinaryTree node, int data){
 if(node == null)
  return (new BinaryTree(data));
 if(data > node.data)
   node.right = insert(node.right,data);
 else
   node.left = insert(node.left, data);

  int leftHeight = getHeight(node.left);
  int rightHeight = getHeight(node.right);
  
  int diff = leftHeight - rightHeight;
  
  if((diff > 1) && (data <= node.left.data)) //New addition is on left and it is straight
    return rightRotate(node);
  if((diff < -1) && (data > node.right.data))
    return leftRotate(node);
 if((diff > 1) && (data > node.left.data)){
   node.left = leftRotate(node.left);
   return rightRotate(node);
 }
 if((diff < -1) && (data <= node.right.data)){
   node.right = rightRotate(node.right);
   return leftRotate(node);
 }
  
 node.height = ((leftHeight > rightHeight) ? leftHeight : rightHeight)+1;

 return node;
}

public void printPreOrder(){
  printPreOrder(root);
}
private void printPreOrder(BinaryTree node){
 if(node == null){
//  Console.Write("(null)");
  return;
 } 
 Console.Write("("+node.data);
 printPreOrder(node.left);
 Console.Write(",");
 printPreOrder(node.right);
 Console.Write(")");
}
}

public static void Main(string[] args){
  SortByAVL.AVL sort = new SortByAVL.AVL();
  int[] sortedArray = {1,2,3,4,5,6,7};
  foreach(int i in sortedArray){
     Console.WriteLine("inserting {0}",i);
     sort.insertNode(i);
  }
  sort.printPreOrder();
}
}
