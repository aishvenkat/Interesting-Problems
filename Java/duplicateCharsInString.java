class duplicateCharsInString{
 public String removeDuplicateChars(String input){
  StringBuilder sb = new StringBuilder(input);
  
  for(int i = 0; i < sb.length()-1; i++)
  {
    for(int j = i+1; j < sb.length();j++)
    {
      if(sb.charAt(i) == sb.charAt(j)){
       sb.deleteCharAt(j); 
      }
    }
  }
  return sb.toString();
 }

 public static void main(String[] args){
   String input = "abcdabe";
  System.out.println(input);
  duplicateCharsInString dupe = new duplicateCharsInString();
  System.out.println(dupe.removeDuplicateChars(input));
 }
}
