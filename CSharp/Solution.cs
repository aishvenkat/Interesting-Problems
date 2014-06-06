using System;
using System.Text;
public class Solution{

 private static ulong findS(string N){
   ulong sum = 0;
   ulong tenSum = 0;
   int stringLen = N.Length;
   ulong modFactor = (ulong)(Math.Pow(10,9)+7);
   for(int i = (stringLen-1); i >=0; i--){
      tenSum = (tenSum + (ulong)Math.Pow(10,(stringLen-1)-i))%modFactor;
      //sum = digit@index * index * tensum
      sum = (sum+((ulong)char.GetNumericValue(N[i])*(ulong)(i+1)*tenSum))%modFactor;
   }
   return (ulong)(sum % modFactor);
 }

public static void Main(string[] args){
 ulong result = Solution.findS(Console.ReadLine().Trim());
/*  ulong maxLength = (ulong)(Math.Pow(10,5)*2);
StringBuilder sb = new StringBuilder();
  for(ulong i = 0; i < maxLength;i++){
   sb.Append("9");
  } 
  Console.WriteLine(sb);
  ulong result = Solution.findS(sb.ToString());*/
  Console.WriteLine(result);
  }
}
