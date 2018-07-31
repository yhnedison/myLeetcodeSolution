import java.util.*;

class Test {
    public static String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        for (char c : time.toCharArray()) {
            if (Character.isDigit(c)) set.add(c - '0');
        }
        
        int curr = 60 * Integer.parseInt(time.split(":")[0]);
        System.out.println(curr);
        curr += Integer.parseInt(time.split(":")[1]);
        System.out.println(curr);
        
        while (true) {
            
            curr = (curr + 1) % (24 * 60);
            System.out.println(curr);
            int[] digits = new int[] {
                curr / 60 / 10,
                curr / 60 % 10,
                curr % 60 / 10,
                curr % 60 % 60
            };
            
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
		String time = "19:35";
		System.out.println(nextClosestTime(time));
	}
}