import java.util.*;
class EightPuzzleBFS{

 List<String> ExploredList = new ArrayList<String>();
 
 public class eightPuzzleNode implements Comparable<eightPuzzleNode>{
   String currentState;
   int pathCost;
   String path;
   
   public eightPuzzleNode(String currentState, int pathCost, String path){
      this.currentState = currentState;
     this.pathCost = pathCost;
     this.path = path;
   }

  //Heuristic h(x)
  private int calculateManhattan(String state){
    int sum = 0;
    for(int i = 0; i < 9; i++)
    {
     int num = Integer.parseInt(String.valueOf(state.charAt(i)));
     if(num == 0) continue;
     sum += (((num /3) - (i/3)) + (num%3) - (i%3));
    }
    return sum;
  }

  public int compareTo(eightPuzzleNode otherNode){
     //cost = f(x) + h(x) 
     //where f(x) is cost per move and h(x) = manhattan distance
     int manhattanCurrent = calculateManhattan(currentState) + pathCost;
     int manhattanOther = calculateManhattan(otherNode.currentState) + otherNode.pathCost;
     return ((manhattanCurrent < manhattanOther) ? -1 :(manhattanCurrent > manhattanOther) ? 1: 0 );
  }
 }

private boolean isGoalState(String state){
   int blankIndex = state.indexOf("0");
   //Delete 0 from the string
   int currentState = Integer.parseInt((new StringBuilder(state)).deleteCharAt(blankIndex).toString());
   if(currentState == 12345678)
     return true;
   return false;
 }


 private List<Integer> AllLegalMoves(int blankIndex){
   List<Integer> legalMoves = new ArrayList<Integer>();
   int blankRow = blankIndex/3;
   int blankCol = blankIndex %3;
   //Move Left
   if((blankRow - 1 ) >= 0) 
	legalMoves.add((blankIndex -3));
   //Move Right
   if((blankRow + 1) < 3)
	legalMoves.add((blankIndex + 3));
   //Move Up
   if((blankCol -1) >= 0)
	legalMoves.add((blankIndex - 1));

   //Move Down
   if((blankCol +1)  < 3)
	legalMoves.add((blankIndex + 1));
   return legalMoves;
   
 }
 
 private boolean explored(String state){
   if(ExploredList.contains(state)){
    return true;
}
  return false;
 }

 private List<String> GetAllStates(String state){
   List<String> states = new ArrayList<String>();
   int blankIndex = state.indexOf("0");
   List<Integer> legalMoves = AllLegalMoves(blankIndex);
   for(int move : legalMoves)
   {
     StringBuilder newState = new StringBuilder(state);
     char temp = newState.charAt(move);
     newState.setCharAt(move,'0');
     newState.setCharAt(blankIndex, temp);
     if(!explored(newState.toString()))
	     states.add(newState.toString());
   }
   return states;
 }
 

 public void AStar(String startState){
 int n = 1;
 eightPuzzleNode goal = null;

 PriorityQueue<eightPuzzleNode> priQueue = new PriorityQueue<eightPuzzleNode>();
 ExploredList = new ArrayList<String>();

 eightPuzzleNode start = new eightPuzzleNode(startState,0,startState);
 ExploredList.add(startState);
 priQueue.add(start);
 
 while(!priQueue.isEmpty()){
  eightPuzzleNode current = priQueue.poll();
  
  List<String> children = GetAllStates(current.currentState);
  for(String child : children){
   n++;
   eightPuzzleNode newChild = new eightPuzzleNode(child,current.pathCost+1,current.path+","+child);
   
   priQueue.add(newChild);
   ExploredList.add(child);
   
   if(isGoalState(child)){
     goal = newChild;
     break;
   }
  }
 if(goal != null) break;
 }
 if(goal == null){
   System.out.println("No goal state found!");
 }
 else{
    System.out.println("path cost:"+goal.pathCost);
    System.out.println("path :"+goal.path);
    System.out.println("Number of states visited = "+n);
 }
 }
 public void BFS(String startState){
   int n = 1;
   eightPuzzleNode goal = null;

   Queue<eightPuzzleNode> BFSQueue = new LinkedList<eightPuzzleNode>();
   ExploredList = new ArrayList<String>();

   eightPuzzleNode start = new eightPuzzleNode(startState,0,new String(startState));
   ExploredList.add(new String(startState));
   BFSQueue.add(start);
   
   while(!BFSQueue.isEmpty()){
     eightPuzzleNode current = BFSQueue.remove();
  
     List<String> children =  GetAllStates(new String(current.currentState));
     for(String child : children){
       n++;
       eightPuzzleNode newChild = new eightPuzzleNode(child,current.pathCost+1,current.path+","+child);
       ExploredList.add(child);
       BFSQueue.add(newChild);

       if(isGoalState(child)){
        goal = newChild;
        break;
       }
       
     }
 if(goal != null) break;
   }
   if(goal == null)
    System.out.println("No goal state was found!");
  else{
    System.out.println("path cost:"+goal.pathCost);
    System.out.println("path :"+goal.path);
    System.out.println("Number of states visited = "+n);
   }
 }

 public static void main(String[] args){
  EightPuzzleBFS p = new EightPuzzleBFS();

  System.out.println("BFS: 013425786");
  p.BFS("013425786");
  System.out.println("A*: 013425786");
  p.AStar("013425786");

  System.out.println("BFS: 724506831");
  p.BFS("724506831");
  System.out.println("A*: 724506831");
  p.AStar("724506831");

 }
}
