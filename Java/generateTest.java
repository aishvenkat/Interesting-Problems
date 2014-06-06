import java.util.*;
public class generateTest{

static Random rand = new Random();
private static String randomBWs()
{
  StringBuilder sb = new StringBuilder("");
  int count = 1000;
  while(count > 0){
  int n = rand.nextInt(3);
   if (n == 0) 
     sb.append('W');
   else
     sb.append('B');
  count--;
  }
 return sb.toString();
}
public static void main(String[] args){
 System.out.println("10");
 for(int i = 0;i < 10; i++)
 {
  System.out.println("1000 1000");
  for(int j = 0; j < 1000;j++)
  {
    System.out.println(randomBWs());
  }
 }
}
}
