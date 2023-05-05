
import java.util.*;

public class DeepCopy {
	public static void main(String[] args) {
		List<Integer> originalList = new ArrayList<>();
    originalList.add(1);
    originalList.add(2);
    originalList.add(3);
    
    List<Integer> deepCopy1 = new ArrayList<>(originalList);
    // or 
    List<Integer> deepCopy2 = new ArrayList<>();
    for (Integer e : originalList) deepCopy2.add(e);
    
    originalList.set(0, 100);
    System.out.println("Original List: " + originalList); // 100,2,3
    System.out.println("Deep Copy List: " + deepCopy1); // 1,2,3
    System.out.println("Deep Copy List: " + deepCopy2); // 1,2,3
	}
}
