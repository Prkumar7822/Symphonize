package java_training;
import java.util.ArrayList;
import java.util.List;
public class Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String a="abcabcc";
		
		
		List<Character> obj=new ArrayList<>();
		int size=0;
		for(int j=0;j<a.length();j++) {
		for(int i=j;i<a.length();i++) {
			size=0;
			if(obj.contains(a.charAt(i))) {
				break;
			}
			else {
				obj.add(a.charAt(i));
			}
			
		}}
		int maxsize=obj.size();
		obj.clear();
		maxsize=Math.max(obj.size(), maxsize);
		System.out.println(maxsize);

	
	}
}
