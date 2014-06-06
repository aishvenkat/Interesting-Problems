import java.util.*;
class NormalDFS{
 class Node{
  public int data;
  public Node next;
  
  public Node(int data){
      this.data = data;
      next = null;
  }
 }
 //Graph elements
 List<Integer>[] Adj;
 int noOfVertices;
 //DFS elements
 int[] pred;
 public enum Colors {WHITE,GRAY,BLACK};
 Colors[] color;
 
 int[] d_time;
 int[] f_time;
 
 static int time;

 public void initializeDFSVars(int noOfVertices)
 {
   this.noOfVertices = noOfVertices;
   Adj = (LinkedList<Integer>[]) new LinkedList<?>[noOfVertices];
   pred = new int[noOfVertices];
   d_time = new int[noOfVertices];
   f_time = new int[noOfVertices];
   color = new Colors[noOfVertices];
   
   for(int i = 0; i < noOfVertices; i++)
   {
     Adj[i] = new LinkedList<Integer>();
   }
 }
 
 public void AddGraphNode(int startNode, int endNode,boolean isDirected){
   //error checking: is startNode || endNode > noOfVertices or negative throw error
   List<Integer> currentStart = Adj[startNode];
   Adj[startNode].add(endNode);
   if(!isDirected)
    Adj[endNode].add(startNode);
 }
 private void initializeDFS()
 {
   for(int i = 0; i < noOfVertices; i++)
   {
     pred[i] = -1;
     d_time[i] = 0;
     f_time[i] = 0;
     color[i] = Colors.WHITE;
   }
   time = 0;
 }
 
 public void DFS(int startNode)
 {
   initializeDFS();
   for(int i = 0; i < noOfVertices; i++)
   {
     if(color[i] == Colors.WHITE){
      DFSVISIT(i,3);
      initializeDFS();
     }
   }
 }

 public void DFSVISIT(int startNode)
 {
   color[startNode] = Colors.GRAY;
   time++;
   d_time[startNode] = time;
   for(int neighbour : Adj[startNode]){
      if(color[neighbour] == Colors.WHITE){
           pred[neighbour] = startNode;
           DFSVISIT(neighbour);
      }
   }
  //Processed
  color[startNode] = Colors.BLACK;
  time++;
  f_time[startNode] = time;
 }

 public void DFSVISIT(int startNode,int cutoff)
 {
   color[startNode] = Colors.GRAY;
   time++;
   d_time[startNode] = time;
   cutoff--;
   for(int neighbour : Adj[startNode]){
      if((cutoff == 0) && (color[neighbour] == Colors.GRAY) && (neighbour != pred[startNode]))
      {
        //FOUND TRIAGLE!
        System.out.println("TRIANGLE:");
        printAncestors(startNode);
      }
      if(cutoff <= 0) break;
      else if(color[neighbour] == Colors.WHITE){
           pred[neighbour] = startNode;
           DFSVISIT(neighbour,cutoff);
      }
   }
  //Processed
  color[startNode] = Colors.BLACK;
  time++;
  f_time[startNode] = time;
 }

 public void printAncestors(int index)
 {
   if(pred[index] == -1){
     System.out.print(index+",");
     return;
   }
   else{
    printAncestors(pred[index]);
    System.out.print(index+",");
   }
 }
 public static void main(String args[])
 {
   NormalDFS dfs = new NormalDFS();
   dfs.initializeDFSVars(8);
   dfs.AddGraphNode(0,2,false);
   dfs.AddGraphNode(0,3,false);
  dfs.AddGraphNode(0,1,false);
  dfs.AddGraphNode(0,4,false);
  dfs.AddGraphNode(1,2,false);
  dfs.AddGraphNode(1,5,false);
  dfs.AddGraphNode(2,3,false);
  dfs.AddGraphNode(2,6,false);
  dfs.AddGraphNode(3,7,false);
  dfs.AddGraphNode(5,6,false);
  dfs.AddGraphNode(4,5,false);
  dfs.AddGraphNode(6,7,false);
  dfs.DFS(0);
 }
}

