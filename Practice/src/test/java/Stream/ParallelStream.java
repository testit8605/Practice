package Stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class ParallelStream {

	public static void main(String[] args) {
		
	//	System.out.println(isPrime(2));
		
		long t1,t2;
		t1= System.currentTimeMillis();
		long count = Stream.iterate(0, n-> n+1).parallel().limit(1000000).filter(ParallelStream:: isPrime).peek(x-> System.out.println(x)).count();
		System.out.println("Total Prime Number: "+ count);
		
		t2= System.currentTimeMillis();
		System.out.println((t2-t1)/1000); //16, 41
	}
	
	public static boolean isPrime(int number)
	{
		if(number<=1)
		return false;
		
		return !IntStream.rangeClosed(2, number/2).anyMatch(x->number%x==0);
	}
}
