import java.io.*;
import java.util.*;
public class Main{
 
private static String canGruSaveMinions(String[] grid,int row){

int trappedRow = -1;
int trappedCol = -1;

for(int i = 1; i < row-1; i++){
 int index = grid[i].indexOf('W',1);
 if((index > 0) && (index != grid[i].length())){ 
   if(!((grid[i-1].charAt(index) == 'W') ||
      (grid[i+1].charAt(index) == 'W') ||
      (grid[i].charAt(index-1) == 'W') ||
      (grid[i].charAt(index+1) == 'W')))
  //Found a trapped Minion
   if(trappedRow == -1){
    trappedRow = i;
    trappedCol = index;
   }
  else{
    if(!((index == trappedCol) || (i == trappedRow)))
    {
       //Failed case
	return "NO";
    }
   }
 }
 
}
 return "YES";
}

public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 int testcases = Integer.parseInt(sc.nextLine());
 while(testcases > 0){
   String[] rowCol = sc.nextLine().split(" ");
   int rows = Integer.parseInt(rowCol[0]);
   int cols = Integer.parseInt(rowCol[1]);
   String[] grid = new String[rows];
   for(int lines = 0; lines < rows; lines++){
     grid[lines] = sc.nextLine().trim();
   }
   System.out.println(canGruSaveMinions(grid,rows));
   testcases--;
 }
 
}
}
