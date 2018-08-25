package lc681;
import java.util.*;

public class Solution2 {

	public String nextClosestTime(String time) {
		// digits can be reused
		
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (Character.isDigit(c)) set.add(c - '0');
        }
        
        int curr = 60 * Integer.parseInt(time.split(":")[0]);
        curr += Integer.parseInt(time.split(":")[1]);
        
        System.out.println(curr);
        
        while (true) {
            
            curr = Math.floorMod((curr - 1), (24 * 60));
            int[] digits = new int[] {
                curr / 60 / 10,
                curr / 60 % 10,
                curr % 60 / 10,
                curr % 60 % 10
            };
            System.out.println(Arrays.toString(digits));
            
            search: {
                for (int d : digits) {
                    if (!set.contains(d)) {
                        break search;
                    }
                }
                return String.format("%02d:%02d", curr/60, curr%60);
            }
            
        }
    }
	
	public static void main(String[] args) {
		String input = "22:22";
		Solution2 sol = new Solution2();
		System.out.println(sol.nextClosestTime(input));
	}

}
