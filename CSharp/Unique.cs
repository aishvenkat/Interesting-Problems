using System;
using System.Text;

public class Unique{

public string RemoveDuplicates(string s){
 int[] alphabets = new int[26];

 StringBuilder sb = new StringBuilder();
 for(int i = 0 ; i < s.Length; i++)
 {
   if(alphabets[(s[i] - 'a')] == 0){ //first occurance of this character
     alphabets[(s[i] - 'a')]++;
     sb.Append(s[i]);
   }
 }
 return sb.ToString();
}

public static void Main(string[] args){
 Unique u = new Unique();
 Console.WriteLine(u.RemoveDuplicates("banana"));
 Console.WriteLine(u.RemoveDuplicates("aardvark"));
 Console.WriteLine(u.RemoveDuplicates("xxxxx"));
 Console.WriteLine(u.RemoveDuplicates("topcoder"));
}
}
