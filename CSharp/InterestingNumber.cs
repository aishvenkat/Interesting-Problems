using System;

public class InterestingNumber{

public string isInteresting(string x){
 int[] firstOccurence = new int[10];
 int[] secondOccurence = new int[10];
 if(!((x.Length % 2) == 0)) return "Not interesting";
 for(int i = 0 ; i < x.Length; i++){
   int digit = (int)char.GetNumericValue(x[i]);
   if(firstOccurence[digit] == 0)
    firstOccurence[digit] = i+1;
   else
    if(secondOccurence[digit] == 0)
     secondOccurence[digit] = i;
    else
     return "Not interesting";
 }
 for(int i = 0; i < 10; i++)
 {
   secondOccurence[i] = secondOccurence[i] - firstOccurence[i];
   if(!((secondOccurence[i] == i) || (secondOccurence[i] == 0)))
    return "Not interesting";
    
 }
  return "Interesting";
}

public static void Main(string[] args){
 InterestingNumber iNum = new InterestingNumber();
 Console.WriteLine(iNum.isInteresting("2002"));
 Console.WriteLine(iNum.isInteresting("1001"));
 Console.WriteLine(iNum.isInteresting("41312432"));
 Console.WriteLine(iNum.isInteresting("611"));
 Console.WriteLine(iNum.isInteresting("64200246"));
 Console.WriteLine(iNum.isInteresting("631413164"));
}
}
