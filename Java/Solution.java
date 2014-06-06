import java.util.*;
import java.math.*;
public class Solution{

 private static long findS(String N){
   long sum = 0;
   long tenSum = 0;
   int StringLen = N.length();
   long modFactor = (long)(Math.pow(10,9)+7);
   for(int i = (StringLen-1); i >=0; i--){
      tenSum +=  (long)Math.pow(10,(StringLen-1)-i);
      sum += ((long)Character.getNumericValue(N.charAt(i))*(long)(i+1)*tenSum);
   }
   return (long)(sum % modFactor);
 }

public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 long result = Solution.findS(sc.nextLine());
  System.out.println(result);
  }
}

