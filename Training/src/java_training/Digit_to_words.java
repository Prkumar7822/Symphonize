package java_training;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Digit_to_words {

	public static void main(String[] args) {
		
		Map<Integer, String> obj=new HashMap<Integer, String>();
		
		Scanner in=new Scanner(System.in);
		
		obj.put(2, "abc");
		obj.put(3, "def");
		obj.put(4, "ghi");
		obj.put(5, "jkl");
		obj.put(6, "mno");
		obj.put(7, "pqrs");
		obj.put(8, "tuv");
		obj.put(9, "wxyz");
		int p = in.nextInt();
		String b="";
		while(p>0){
			int rem=p%10;
			b=obj.get(rem)+b;
			p=p/10;
		}
//		System.out.println(b);
		for(int i=0;i<b.length();i++) {
			for(int j=i+1;j<b.length();j++) {
				System.out.println(b.charAt(i)+""+b.charAt(j));
			}
		}
		
	}

}
