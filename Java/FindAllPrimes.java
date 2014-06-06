import java.util.*;
class FindAllPrimes{
  List<Integer> Primes = new ArrayList<Integer>();

  public void getAllPrimes(int start, int end){
    Primes.add(2);
    for(int i=3; i <= end; i+=2){
     for(int prevPrime : Primes){
        if(i%prevPrime == 0)
          break;//Not Prime
	if(prevPrime > (int)Math.sqrt(i)){
	    Primes.add(i);//Prime
	    break;
               }
     }
    }
   for(int prevPrime :Primes)
     System.out.println(prevPrime);
}
 public static void main(String[] args){
    FindAllPrimes fp = new FindAllPrimes();
   fp.getAllPrimes(1,1000);
 }
}
