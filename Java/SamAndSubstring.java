import java.util.*;
public class Solution{

 private static long findS(String N){
   long sum = 0;
   long tenSum = 0;
   int stringLen = N.length;
   long modFactor = (long)(Math.pow(10,9)+7);
   for(int i = (stringLen-1); i >=0; i--){
      tenSum = (tenSum + (long)Math.pow(10,(stringLen-1)-i))%modFactor;
      //sum = digit@index * index * tensum
      sum = (sum+((long)Character.getNumericValue(N.getCharAt(i))*(long)(i+1)*tenSum))%modFactor;
   }
   return (long)(sum % modFactor);
 }

public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 long result = Solution.findS(sc.nextLine().Trim());
/*  ulong maxLength = (ulong)(Math.Pow(10,5)*2);
StringBuilder sb = new StringBuilder();
  for(ulong i = 0; i < maxLength;i++){
   sb.Append("9");
  } 
  Console.WriteLine(sb);
  ulong result = Solution.findS(sb.ToString());*/
  System.out.println(result);
  }
}

