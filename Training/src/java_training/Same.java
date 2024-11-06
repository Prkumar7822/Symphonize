package java_training;

public class Same {
public static boolean main(String[] args) {
	boolean b=true;

	String s="aaa";
	
	for(int i=0;i<s.length();i++) {
		for(int j=i+1;j<s.length();j++){
			if(s.charAt(i)!=s.charAt(j)) {
				b=false;
			}
			
		}
	}
	return b;
	
}}
