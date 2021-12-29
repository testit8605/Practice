package Stream2;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntArrayWithFlatMap {

	public static void main(String[] args) {
		
		
		int data[] = {1,2,3,4,4,5,6,7,7,9};
		Stream<int[]> streamArray = Stream.of(data);
		IntStream intStream = streamArray.flatMapToInt(x-> Arrays.stream(x));
		intStream.forEach(x-> System.out.println(x));
		
		
		
	}

}
