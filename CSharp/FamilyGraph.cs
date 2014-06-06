using System;
using System.Collections.Generic;

public class FamilyGraph{
 List<int>[] parentEdges;

 int[] discovered;

 private bool canBe2Colored(){
  discovered = new int[parentEdges.Length];
  for(int i = 0; i < discovered.Length; i++){
    if(discovered[i] == 0){
     bool bicolored = bfsWithBiColoring(i);
     if(!bicolored) return false;
    }
  }
   return true;
 }
 private bool bfsWithBiColoring(int start){
  Queue<int> bfsQueue = new Queue<int>();
  int[] colors = new int[parentEdges.Length];
  discovered[start] = 1;
  bfsQueue.Enqueue(start);
  while(bfsQueue.Count > 0){
    int currentParent = bfsQueue.Dequeue();
//    Console.WriteLine("for parent:"+currentParent);
    foreach(int secondParent in parentEdges[currentParent]){
  //     Console.WriteLine("child"+secondParent);
       if(colors[currentParent] == colors[secondParent]){
          colors[secondParent]++;
          if((colors[secondParent]+1) > 2)
           return false;
          
       }
     if(discovered[secondParent] == 0){
    // Console.WriteLine("queueing:"+secondParent);
     bfsQueue.Enqueue(secondParent);
     discovered[secondParent] =1;
    }
  }
 }
  return true;
 }
 public string isFamily(int[] parent1, int[] parent2){
  parentEdges = new List<int>[parent1.Length];
  for(int i = 0; i < parent1.Length; i++){
    parentEdges[i] = new List<int>();
    if(parent1[i] != -1) //if parent1 == -1, parent2 will automatically be -1. No need to verify
    {
       //Again it is assumed that parent[i] WILL be between 0 and i-1 inclusive
       parentEdges[parent1[i]].Add(parent2[i]);
       parentEdges[parent2[i]].Add(parent1[i]);
       Console.WriteLine("Added:"+parent1[i]+"---"+parent2[i]);
    }
  }
  
  if(canBe2Colored())
   return "Possible";
  return "Impossible";
  
 }


 public static void Main(string[] args){
/*  int[] parent1 = {-1,-1,0};
  int[] parent2 = {-1,-1,1};
*/
int[] parent1 = {-1,-1,-1,-1,1,-1,0,5,6,-1,0,3,8,6};
int[] parent2 = {-1,-1,-1,-1,3,-1,4,6,5,-1,5,4,6,1};

//Returns: "Possible"

/*
int[] parent1 = {-1,-1,-1,2,2,-1,5,6,4,6,2,1,8,0,2,4,6,9,-1,16,-1,11};
int[] parent2 = {-1,-1,-1,1,0,-1,1,4,2,0,4,8,2,3,0,5,14,14,-1,7,-1,13};
//Returns: "Impossible"
*/
  FamilyGraph fam = new FamilyGraph();
  Console.WriteLine(fam.isFamily(parent1,parent2));
 }
}
