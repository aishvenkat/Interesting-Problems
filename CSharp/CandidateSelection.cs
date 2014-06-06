using System;

public class CandidateSelection{
public string Possible(string[] score, int[] result){
  string[] orderedList = new string[result.Length];
  bool isZeroDay = true;
  for(int i = 0; i < result.Length; i++){
   orderedList[i] = score[result[i]];
   if((isZeroDay) && (i != result[i]))
    isZeroDay = false;
  }

  if(isZeroDay) 
	return "Possible";

  for(int m = 0; m < orderedList[0].Length; m++)
  {
    int candidate1 = orderedList[0][m];
    int n = 1;
    for(; n < orderedList.Length; n++){
      if((candidate1 - orderedList[n][m]) > 0)
       break;
      if((candidate1 - orderedList[n][m]) == 0){
        if(result[n-1] > result[n])
        break;
       }
      candidate1 = orderedList[n][m];
    }
    if(n == orderedList.Length)
      return "Possible";
  }
  return "Impossible";
}

public static void Main(string[] args){

CandidateSelection c = new CandidateSelection();

string[] score1 ={"CC","AA","BB"};
int[] result1 = {1,2,0}; 
Console.WriteLine(c.Possible(score1, result1));

string[] score2 ={"BAB", "ABB", "AAB", "ABA"};
int[] result2 = {2,0,1,3};
Console.WriteLine(c.Possible(score2, result2));


string[] score3 = {"BAB", "ABB", "AAB", "ABA"};
int[] result3 = {0, 1, 3, 2};
Console.WriteLine(c.Possible(score3, result3));

string[] score4 = {"AAA", "ZZZ"};
int[] result4 = {1, 0};
Console.WriteLine(c.Possible(score4, result4));

string[] score5 = {"ZZZ", "AAA"};
int[] result5 = {0, 1};
Console.WriteLine(c.Possible(score5, result5));

string[] score6 = {"ZYYYYX","YXZYXY","ZZZZXX","XZXYYX","ZZZYYZ","ZZXXYZ","ZYZZXZ","XZYYZX"};
int[] result6 = {3,7,1,0,2,5,6,4};
Console.WriteLine(c.Possible(score6, result6));

string[] score7 ={"AB","AC","BA"};
int[] result7 = {1,0,2}; 
Console.WriteLine(c.Possible(score7, result7));
}

}
