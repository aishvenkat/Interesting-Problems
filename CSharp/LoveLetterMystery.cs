using System;

public class LoveLetterMystery{

  public static void calculateCost(string input){
    int cost = 0;
    int strLength = input.Length;
    for(int i = 0; i < strLength/2;i++)
     cost += Math.Abs(input[i] - input[strLength-1-i]);
    Console.WriteLine(cost);
  } 

  public static void Main(string[] args){
   int _testcases = int.Parse(Console.ReadLine());
   for(int i = 0; i < _testcases;i++)
	calculateCost(Console.ReadLine());
  }
}
