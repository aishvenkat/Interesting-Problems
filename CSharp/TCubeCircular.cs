/*using System;
using System.Collections.Generic;

namespace topCode{ 
public class TCubeCircular{

public int countNumber(int N){
List<int> circularBuffer = new List<int>();
for(int i = 0; i < N;i++){
 circularBuffer.Add(i+1);
}

int threshold =1;
int head = 0;

while(circularBuffer.Count > 1){
 int size = circularBuffer.Count;
 int eliminate = ((int)Math.Pow(threshold,3))%size;
 eliminate = ((size+head+eliminate-1)%size);
 circularBuffer.RemoveAt(eliminate);
 head = eliminate%circularBuffer.Count;
 threshold++;
}

Console.WriteLine(circularBuffer[0]);
return circularBuffer[0];
}
*/

using System;
using System.Collections.Generic;
public class ChooseTheBestOne{

  public int countNumber(int N){
     List<int> circular = new List<int>();
     int t = 1;
     for(int i =0 ; i < N; i++)
     {
       circular.Add(i+1);
     }
     
     int head = 0;
     while(circular.Count > 0){
      int size = circular.Count;
      int eliminate = ((int) Math.pow(t,3));
      eliminate = ((size+head+eliminate -1)%size);
      circular.RemoveAt(eliminate);
      head = eliminate%circular.Count;
      t++;
     }
     Console.WriteLine(circular[0]);
     return circular[0];
  }

public static void Main(string[] args){
TCubeCircular t = new TCubeCircular();
t.countNumber(1234);
}
}

