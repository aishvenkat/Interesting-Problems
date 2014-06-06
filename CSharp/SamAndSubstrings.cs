using System;

public class SamAndSubstring{

 private static int findS(string N){
   double sum = 0;
   double tenSum = 0;
   int stringLen = N.Length;
   double modFactor = (Math.Pow(10,9)+7);
   for(int i = (stringLen-1); i >=0; i--){
      tenSum += (Math.Pow(10,(stringLen-1)-i) % modFactor);
      //sum = digit@index * index * tensum
      sum += (char.GetNumericValue(N[i])*(i+1)*tenSum)% modFactor;
   }
   return (int)sum;
 }

public static void Main(string[] args){

  int result = SamAndSubstring.findS(Console.ReadLine().Trim());
  Console.WriteLine(result);
}
}
