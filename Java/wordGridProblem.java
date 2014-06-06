import java.util.*
public class WordGridProblem{

char[][] wordGrid = {{'a','y','e','b'},{'x','x','l','a'},{'o','a','r','d'},{'a','r','o','w'}};

List<String> explored = new ArrayList<String>();
private void initializeRound(){
  explored = new ArrayList<String>();
}

public boolean DFS(string input)
{
 boolean wordFound = false;
 int iterDeepening = input.length();
 for(int i = 0; i < 4; i++)
 {
  for(int j = 0; j < 4; j++){
   if(wordGrid[i][j] == input.charAt(0)){
      explored.add(""+i+j);
      if( DFSVisit(i,j,input,0))
         return true;
      }
  }
 }
  return false;
}

private HashMap<Integer,Integer> findAllNeighbours(int row, int col)
{
  HashMap<Integer,Integer> neighbours = new HashMap<Integer,Integer>();
  if((row > 0) && (col > 0))
   neighbour.put(row-1,col-1);
  
  if((row < 0) && (col > 0))
   neighbour.put(row-1,col-1);
}
private boolean DFSVisit(int i , int j, string input, int index){
  
  if(i > 0)
   
}
}
