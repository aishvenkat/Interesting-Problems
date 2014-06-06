import java.io.*;
import java.util.*;

/***
 Given a set of words from a new dictionary finds the lexicographical order
*/
public class NewDictionary{
int  MAXINT = 2147483647;
HashMap<Character,Integer> SmallerCount = new HashMap<Character,Integer>();

HashMap<Character,ArrayList<Character>> relations = new HashMap<Character,ArrayList<Character>>();
List<Character> orderInDict = new ArrayList<Character>();
private void  initialize()
{
  for(int i = 'a'; i <='z'; i++)
  {
    SmallerCount.put((char)i,0);
    relations.put((char)i, new ArrayList<Character>());
  }
}
public void  ReadWordsAndLoad(List<String> words){
 initialize();
 int Inputcount = words.size();
 
  for(int i = 0; i < Inputcount-1; i++){
  int len = (int) ((words.get(i).length() > words.get(i+1).length()) ? words.get(i+1).length() : words.get(i).length());
  int count = 0;
  while(len > count){
    if(words.get(i).charAt(count) == words.get(i+1).charAt(count)){
    count++;
    }
    else{
		ArrayList<Character> values = relations.get(words.get(i).charAt(count));
                values.add(words.get(i+1).charAt(count));
                
		SmallerCount.put(words.get(i+1).charAt(count), SmallerCount.get(words.get(i+1).charAt(count))+1);
                break;
        }
  }
}
}

public void  ProcessRelations()
{
 //Find smallest alphabet
 int min = MAXINT;
 char minKey = 'a';
 for(char alpha : SmallerCount.keySet())
 {
  if(SmallerCount.get(alpha) < min){
   minKey = alpha;
   min = SmallerCount.get(alpha);
}
 }

 orderInDict.add(minKey);
 
//Find all other alphabets
 while( true)
 {
 min = MAXINT;
 ArrayList<Character> firstSet = relations.get(minKey);
 if(firstSet.size() <= 0) break;
 for(char relationsForMin : firstSet){
   SmallerCount.put(relationsForMin,SmallerCount.get(relationsForMin)-1);
   if(SmallerCount.get(relationsForMin) < min){
    minKey = relationsForMin;
    min = SmallerCount.get(relationsForMin);
    }
 }
 orderInDict.add(minKey);
}

 //Print all alphabets in order
 for(int i = 0; i < orderInDict.size(); i++)
 {
	System.out.println(orderInDict.get(i));
 }

}

public static void main(String[] args){
 NewDictionary dict = new NewDictionary();
 List<String> words = new ArrayList<String>();
 Scanner sc = new Scanner(System.in);
 while(sc.hasNextLine()){
   words.add(sc.nextLine().trim());
 }
 dict.ReadWordsAndLoad(words);
 dict.ProcessRelations();
 }
}
