package lc253;
import java.util.*;

public class Solution {

	public int minMeetingRooms(Interval[] intervals) {
		// Wrong solution, cannot guarantee minimum room numbers
        List<List<Interval>> rooms = new ArrayList<List<Interval>>();
 
        for (Interval i: intervals) {
            
            boolean found = false;            
            roomSearch: for (List<Interval> room: rooms) {
                for (Interval j: room) {
                    if ((i.start <= j.start && i.end > j.start) || 
                    	(i.start < j.end && i.end >= j.end) || 
                    	(i.start >= j.start && i.end <= j.end)) { // conflict, room not available, continue to next room
                    	continue roomSearch;
                    }
                }
                found = true;
                room.add(i);
                break roomSearch;
                
            }
            if (!found) {
                List<Interval> newRoom = new ArrayList<Interval>();
                newRoom.add(i);
                rooms.add(newRoom);
            }
            present(rooms);
        }
        
        return rooms.size();
        
    }
	
	public void present(List<List<Interval>> rooms) {
		for (List<Interval> l1 : rooms) {
			   for (Interval n : l1) {
			       System.out.print(n.start + "-" + n.end + " "); 
			   }

			   System.out.println();
			} 

	}

	public static void main(String[] args) {
		Interval[] input = new Interval[3];
		input[0] = new Interval(1,5);
		input[1] = new Interval(8, 9);
		input[2] = new Interval(8, 9);
		Solution sol = new Solution();
		
		System.out.println(sol.minMeetingRooms(input));
		
	}

}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
