package java_training;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Remove_Dup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="I love to to coding";
		StringTokenizer obj=new StringTokenizer(s," ");
		//System.out.println(obj);
		Set<String> obj1=new LinkedHashSet<>();

		while(obj.hasMoreTokens()) {
			obj1.add(obj.nextToken());
		}
//		System.out.println(obj1);
		String p=String.join(" ",obj1);
		System.out.println(p);
	}

}
