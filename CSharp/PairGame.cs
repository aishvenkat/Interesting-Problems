using System;
public class PairGame{
  public int maxSum(int a , int b, int c, int d){
   while((a>0) && (b>0) && (c>0) && (d>0)){
    if((a==c) && (b==d))
    	return (a+b);
    if((a==c) || (b==d)){
     if(a==c){
      if(b > d)
         b = b-a;
      else
         d = d-c;
    }
    if(b==d){
      if(a > c)
        a = a-b;
      else
       c = c-d;
     }
    }
    else{
      if(a > b)
         a = a -b;
      else
        b = b - a;
      if(c > d)
      	c = c -d;
      else
       d = d -c;
    }
   }
   return -1;
  }


/*using System;

public class PairGame{

public int maxSum(int a, int b, int c, int d){
 while((a >0) && (b > 0) && (c>0) && (d >0)){
   //Goal State
   if((a==c) && (b==d)) return (a+b);
   if((a==c) || (b==d)){
     if(a==c){
       if(b > d)
	 b = b-a;
       else
	d = d -c;
     }
     if(b == d){
       if(a > c)
	a = a-b;
       else
	c = c-d;
     }
   }
  else{
    if(a > b)
      a = a - b;
    else
      b= b - a;
    if(c > d)
	c = c - d;
    else
	d = d -c;
  }
 }
 return -1;
}
*/
public static void Main(string[] args){
 PairGame p = new PairGame();
 Console.WriteLine(p.maxSum(1,2,2,1));
 Console.WriteLine(p.maxSum(15,4,10,7));
 Console.WriteLine(p.maxSum(1,1,10,10));
 Console.WriteLine(p.maxSum(1000,1001,2000,2001));
 Console.WriteLine(p.maxSum(10944,17928,7704,21888));
 Console.WriteLine(p.maxSum(1,1,1,1));
 int num = ('B' - 'A');
 Console.WriteLine(num);
}
}
