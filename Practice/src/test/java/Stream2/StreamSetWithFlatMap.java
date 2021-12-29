package Stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class StreamSetWithFlatMap {

	public static void main(String[] args) {
		
		
		Employee e1 = new Employee();
		e1.setName("Akshay");
		
		e1.addDevices("Iphone8");
		e1.addDevices("samsung9");
		e1.addDevices("Iphonex");
		e1.addDevices("macbookPro");
		
		Employee e2 = new Employee();
		e2.setName("Sanju");
		
		e2.addDevices("lenovo w");
		e2.addDevices("samsung9");
		e2.addDevices("Iphone9");
		e2.addDevices("macbook air");
		
		List<Employee> employee =  new ArrayList<Employee>();
		employee.add(e1);
		employee.add(e2);
		
		
		//Printing unique name
		List<String> devicesList = employee.stream().map(x-> x.getDevices()).flatMap(x-> x.stream()).distinct().collect(Collectors.toList());
		devicesList.forEach(System.out::println);
		
		
	}

}
