import java.util.*;
public class Champaign{
 double[] cups;
 double CUP_CAPACITY = 2;
  int requiredCup = 0;
 public int pour(int cupNo,double amountOfLiquid,int level){
  double excess = amountOfLiquid -( CUP_CAPACITY - cups[cupNo]);
//  System.out.println("CupNo:"+cupNo+"liquid in cup:"+cups[cupNo]+"amount of liquid"+amountOfLiquid+"excess:"+excess);
  if(excess >=0){
        cups[cupNo] = CUP_CAPACITY;
 	if(cupNo == requiredCup){
	 return 1;
      }
     level++;
     if(pour(cupNo+level,excess/2,level) == 1) return 1;
     if(pour(cupNo+level+1,excess/2,level) == 1) return 1;
  }
  else{
	cups[cupNo] += amountOfLiquid;
      }
    
   return 0;
 }

public void getLiquidInCup(int index, int height, int liquidPoured){
 int sqrt = (int)(Math.sqrt(liquidPoured) + 0.5);
 int noOfCups = (sqrt*(sqrt+1))/2;
 cups = new double[noOfCups];
 int cupIndexFinder = (height*(height+1))/2;
 requiredCup = (cupIndexFinder-height+index);
 pour(0,liquidPoured,0);
 System.out.println("required cup height:"+height+" index:"+index+" quantity:"+cups[requiredCup]);
}

public static void main(String[] args){
 Champaign pourChampaign = new Champaign();
  pourChampaign.getLiquidInCup(0,3,14);
  pourChampaign.getLiquidInCup(1,3,14);
  pourChampaign.getLiquidInCup(2,4,14);
  pourChampaign.getLiquidInCup(0,4,14);
  pourChampaign.getLiquidInCup(1,4,20);
}
}
