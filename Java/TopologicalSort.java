import java.util.*;
class TopologicalSort{
 /*class Node{
   public int data;
   public Node next;

   public Node(int data)
   {
     this.data = data;
     next = null;
   }
 }*/
  
  //class DepthFirst{
   public enum Colors {WHITE,GRAY,BLACK};
   Colors[] color;
   int NoOfVertices;
   List<Integer>[] Adj;
   Stack<Integer> TopoSort = new Stack<Integer>();
  public void initializeDFS(int NoOfVertices){
    this.NoOfVertices = NoOfVertices;
    Adj = (ArrayList<Integer>[])new ArrayList<?>[NoOfVertices];
    color = new Colors[NoOfVertices];
    for(int i = 0; i < NoOfVertices; i++)
    {
     Adj[i] = new ArrayList<Integer>();
     color[i] = Colors.WHITE;
    }
  }

  public void AddNode(int startNode,int endNode,boolean isDirected){
    Adj[startNode].add(endNode);
   if(!isDirected){
      if(Adj[endNode] == null)
        Adj[endNode] = new ArrayList<Integer>();
      Adj[endNode].add(startNode);
   }
  }
  

  public void DFS()
  {
    for(int i = 0; i < NoOfVertices; i++){
      if(color[i] == (Colors.WHITE))
        DfsVisit(i);
    }
  }
  
  public void DfsVisit(int startNode){
   color[startNode] = Colors.GRAY;
   for(int neighbour : Adj[startNode])
   {
     if(color[neighbour] == (Colors.WHITE)){
       DfsVisit(neighbour);
     }
   }
  color[startNode] = Colors.BLACK;
  TopoSort.push(startNode);
  }

 
 // }

public static void main(String[] args){
TopologicalSort ts = new TopologicalSort();

ts.initializeDFS(5);
ts.AddNode(0,1,true);
ts.AddNode(0,2,true);
ts.AddNode(0,3,true);
ts.AddNode(1,3,true);
ts.AddNode(1,4,true);
ts.AddNode(2,1,true);
ts.AddNode(2,4,true);
ts.AddNode(3,4,true);

ts.DFS();

while(!ts.TopoSort.empty()){
  System.out.println(ts.TopoSort.pop());
}

} 
}
