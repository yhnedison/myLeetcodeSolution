
public class LinkedList {
    private ListNode header;
	
	public LinkedList() {
		header = new ListNode(null);
	}
	
	public boolean isEmpty() {
		return header.next == null;
	}
	
	public void makeEmpty() {
		header.next = null;
	}
	
	// insert after header
	public void insert(int x) {
		ListNode temp = new ListNode(x);
		temp.setNext(header.getNext());
		header.setNext(temp);
	}
	
	// remove last node
	public void remove() {
		ListNode itr, preItr;
		
		if ((preItr = header.getNext()) == null) return;
		if ((itr = preItr.getNext()) == null) return;
		
		while (itr.getNext() != null) {
			preItr = itr;
			itr = itr.getNext();
		}
		preItr.setNext(null);
	}
	
	public boolean find(int x) {
		ListNode itr = header;
		while ((itr = itr.getNext()) != null) {
			if (itr.getValue().equals(x)) return true;
		}
		return false;
	}
	
}
