package java_training;

import java.util.Stack;

public class Brace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> obj=new Stack<Character>();
		
		String s="({]})";
		
		for(char i:s.toCharArray()) {
			if(i=='('||i=='{'||i=='[') {
				obj.push(i);
			}
			else if(i==')'||i=='}'||i==']') {
				if(obj.isEmpty()) {
					System.out.println("false");
				}
				else {
					char top=obj.pop();
					if((top=='}'&&top!='{')||
					(top==']'&&top!='[')||
						(top==')'&&top!='(')	
							
							) {
System.out.println("false");					}
				}
			}
		}
System.out.println(obj.isEmpty());		
	}

}
