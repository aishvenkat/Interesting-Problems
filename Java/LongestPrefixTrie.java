import java.util.*;

class TrieNode{
 char value;
 HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
 boolean bIsEnd;
public TrieNode(char value){
 this.value = value;
 bIsEnd = false;
 children = new HashMap<Character,TrieNode>();
}

}
class Trie{
 TrieNode root;
 public Trie()
 {
  this.root = new TrieNode((char)0);
 }

 public void insertWord(String word){
  int wordLevel = word.length();
  TrieNode crawl = root;
  for(int i =0; i < wordLevel; i++){
   char currentChar = word.charAt(i);
   if(crawl.children.containsKey(currentChar))
   {
      crawl = crawl.children.get(currentChar);
   }
   else{
     TrieNode temp = new TrieNode(currentChar);
     crawl.children.put(currentChar,temp);
     crawl = temp;
   }
  }
   crawl.bIsEnd = true;
 }

 public String longestPalindrome(String input){
  int wordLevel = input.length();
  TrieNode crawl = root;
  int previousLongestPrefix = 0;

  for(int i = 0; i < wordLevel; i++){
   char currentChar = input.charAt(i);
   if(crawl.children.containsKey(currentChar))
   {
     crawl = crawl.children.get(currentChar);
     if(crawl.bIsEnd) {previousLongestPrefix = i+1;}
   }
   else{
        break;
       }
  }
     return input.substring(0,previousLongestPrefix);
 }
}

public class LongestPrefixTrie{
public static void main(String[] args){
  Trie t = new Trie();
  t.insertWord("are"); 
  t.insertWord("area");
  System.out.println("areb:"+t.longestPalindrome("areb")); 
  System.out.println("areat:"+t.longestPalindrome("areat")); 
  System.out.println("area:"+t.longestPalindrome("area")); 
}
}
