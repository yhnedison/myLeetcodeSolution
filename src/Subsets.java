import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
	/*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
    		List<List<Integer>> results = new LinkedList<>();
    		
    		if (nums == null) {
    			return results;
    		}
    		
    		Arrays.sort(nums);
    		
    		
    		
    		
    		
		return results;
    }
    
    public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempList = new ArrayList<>();
		list.add(new ArrayList<>(tempList));
		System.out.println(list);
	}
}
