import java.util.*;
public class LongestStringNoRepeat{
 HashMap<Character,Integer> charIndex = new HashMap<Character,Integer>();
 
 public String LongestNonRepeatingSubstring(String input){
  int prevStart = 0;
  int maxLength = 0;
  int newStart = 0;
  int currentLength = 0;
  for(int i = 0; i < input.length();i++){
   if(charIndex.containsKey(input.charAt(i)))
    {
     if(maxLength < currentLength) {
        maxLength = currentLength;
        prevStart = newStart;
        }
        newStart = charIndex.get(input.charAt(i)) + 1;
        charIndex.put(input.charAt(i),i);
        currentLength--;
    }
      charIndex.put(input.charAt(i),i);
      currentLength++;
  }
   if(currentLength > maxLength) {
          maxLength = currentLength;
          prevStart = newStart;
   }
   return input.substring(prevStart,(prevStart+maxLength));
 }

public static void main(String[] args){
  LongestStringNoRepeat str = new LongestStringNoRepeat();
  System.out.println(  str.LongestNonRepeatingSubstring("abcadbc"));
}
}
