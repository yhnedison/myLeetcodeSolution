
public class ListNode {
	Object element;
	ListNode next;
	
	public ListNode(Object value) {
		element = value;
		next = null;
	}
	
	public ListNode(Object value, ListNode n) {
		element = value;
		next = n;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext(ListNode x) {
		next = x;
	}
	
	public Object getValue() {
		return element;
	}
	
	public void setValue(Object x) {
		element = x;
	}
	
	public boolean equals (Object value) {
		return element == value;
	}
}
