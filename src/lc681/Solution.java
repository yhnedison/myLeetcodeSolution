package lc681;

import java.util.*;

public class Solution {

	public String nextClosestTime(String time) {
        // every digit can be used only once
        // only hour can have 1 digit
        Map<Integer, Boolean> map = new HashMap<>(); // map<digit, occurrence>
        String hour = time.split(":")[0], minute = time.split(":")[1];
        
        int curr = 60 * Integer.parseInt(hour) + Integer.parseInt(minute);
        
        if (hour.length() == 1) { // if hour has 1 digit, add digit "0"
            map.put(0, false);
        }
        
        for (char c: time.toCharArray()) { // add all digits
            if (Character.isDigit(c)) map.put(c - '0', false);
        }
        
        while (true) {
            curr = (curr + 1) % (24 * 60);
            int[] digits = new int[]{
                curr / 60 / 10, 
                curr / 60 % 10, 
                curr % 60 / 10, 
                curr % 60 % 10
            };
            
            search: {
                for (int d: digits) {
                    if (!map.containsKey(d)) {
                        break search;
                    } else if (map.containsKey(d) && map.get(d) == true) {
                        break search;
                    } else if (map.containsKey(d) && map.get(d) == false) {
                        map.put(d, true);
                    }
                }   
                return String.format("%02d:%02d", curr/60, curr%60);
            }
            
            // reset map to all false
            for (Map.Entry<Integer, Boolean> entry: map.entrySet()) {
                map.put(entry.getKey(), false);
            }
            
        }
        
    }
	
	public static void main(String[] args) {
		String input = "1:29";
		Solution sol = new Solution();
		System.out.println(sol.nextClosestTime(input));
	}

}
