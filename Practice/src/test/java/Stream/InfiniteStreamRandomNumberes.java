package Stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreamRandomNumberes {

	public static void main(String[] args) {
		
		
		List<Integer> l = IntStream.iterate(0, n->n+2).mapToObj(Integer::valueOf).limit(10).collect(Collectors.toList());
		System.out.println(l);
		
		
		List<Integer> j = Stream.generate(() -> (new Random()).nextInt(100)).limit(10).collect(Collectors.toList());
		System.out.println(j);
		
		
	}

}
