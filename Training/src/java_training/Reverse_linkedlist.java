package java_training;

import java.util.LinkedList;
import java.util.Stack;

public class Reverse_linkedlist {

	public static void main(String[] args) {
		
		LinkedList<Integer> obj=new LinkedList<Integer>();
		
//		int current = obj.h
		
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.add(4);
		Stack<Integer> s=new Stack<Integer>();
		
		
		while(obj!=null) {
			s.push(obj.getFirst());
//			obj=obj.next;
			
		}
		
		

	}

}
