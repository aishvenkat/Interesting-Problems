using System;
using System.Threading;

public class FibonacciThread{

int[] fibonacciSeries;

private void CalculateFibonacci(int n){
  fibonacciSeries = new int[n];
  for(int i = 0; i < n; i++){
    if((i==0)||(i==1)){
      fibonacciSeries[i] = 1;
      continue;
    }
    fibonacciSeries[i] = fibonacciSeries[i-1] + fibonacciSeries[i-2];
  }
  
}

public void printFibonacci(int n)
{
 Thread childThread = new Thread(()=>CalculateFibonacci(n));
 childThread.Start();
 childThread.Join();
for(int i = 0; i < n; i++)
 Console.WriteLine(fibonacciSeries[i]); 
}

public static void Main(string[] args)
{
 Console.Write("Enter n:");
 int n = int.Parse(Console.ReadLine().Trim());
 FibonacciThread fibo = new FibonacciThread();
 fibo.printFibonacci(n);
}
}
