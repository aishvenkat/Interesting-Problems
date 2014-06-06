using System;
using System.Collections.Generic;

public class Knapsack{
int[,] memoizedTable;
int[] values;
int[] weights;

public void MaxKnapsackValue(int noOfItem, int Weight){
memoizedTable = new int[noOfItem+1, Weight+1];
for(int i = 0; i <= noOfItem; i++)
 for(int j= 0; j<= Weight;j++)
  memoizedTable[i,j] = -1;
Console.WriteLine(calculateKnapsack(noOfItem, Weight));

}

private int max(int a, int b){

 return ((a>b)? a: b); 
}

public int calculateKnapsack(int n,int W){
Console.WriteLine("N:"+n+"W:"+W);
if((n ==0) || (W == 0)){
 memoizedTable[n,W] = 0;
 return memoizedTable[n,W];
}

if(memoizedTable[n,W] != -1)
  return memoizedTable[n,W];

if(weights[n-1] > W)
 memoizedTable[n,W] = calculateKnapsack(n-1,W);

else
 memoizedTable[n,W] = max(
			(values[n-1] + calculateKnapsack(n-1,W-weights[n-1])),
			calculateKnapsack(n-1,W));

 return memoizedTable[n,W];
}

public static void Main(string[] args){

    Knapsack k = new Knapsack();
    k.values = new int[]{60, 100, 120};
    k.weights = new int[]{10, 20, 30};
    int  W = 50;
    k.MaxKnapsackValue( k.values.Length,W);
}
}
