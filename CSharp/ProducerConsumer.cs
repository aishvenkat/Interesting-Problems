using System;
using System.Threading;


public class ProducerConsumer{
static int[] buffer;
public static Semaphore counterSemaphore = new Semaphore(1,1);
public static Semaphore bufferFilled;
public static Semaphore bufferUsed;
public static bool timeOut = false;
public static Random rand = new Random();
public static int head = 0;
public static int counter = 0;
public static int num = 1;

 public class ProducerClass{
  public static void ThreadRun(){
    while(!timeOut){
//     If all indices have been filled wait for consumer to consume
       ProducerConsumer.bufferUsed.WaitOne();
//       int newItem = rand.Next();
       int newItem = num++;
       Console.WriteLine("Producer:"+newItem);

//     Lock counter
       ProducerConsumer.counterSemaphore.WaitOne();
       buffer[(head+counter)%buffer.Length] = newItem;
       counter++;
       ProducerConsumer.counterSemaphore.Release();
//     Unlock counter

//     Signal that buffer has new data
       ProducerConsumer.bufferFilled.Release();
    }
  }
 }
 public class ConsumerClass{
  public static void ThreadRun(){
  while(!timeOut){
//     Wait if no indices have data filled by Producer
       ProducerConsumer.bufferFilled.WaitOne();

//     Lock Counter
       ProducerConsumer.counterSemaphore.WaitOne();
       int newItem = buffer[head];
       Console.WriteLine("Consumer:"+newItem);
       head = (head+1)%buffer.Length;
       counter--;
       ProducerConsumer.counterSemaphore.Release();
//     Unlock Counter

//     Signal that buffer has a new free space
       ProducerConsumer.bufferUsed.Release();
  }
  }
 }

 public static void Main(string[] args){
  int bufferSize = 5;
  buffer = new int[bufferSize];
  ProducerConsumer.bufferFilled = new Semaphore(0,bufferSize);
  ProducerConsumer.bufferUsed = new Semaphore(bufferSize,bufferSize);

  Thread producer = new Thread(()=>ProducerConsumer.ProducerClass.ThreadRun());
  Thread consumer = new Thread(()=>ProducerConsumer.ConsumerClass.ThreadRun());
  
  producer.Start();
  consumer.Start();
  
  Thread.Sleep(3000);
  Console.WriteLine("TimeOut!!");
  ProducerConsumer.timeOut = true;

  producer.Join();
  consumer.Join();
 }
}
