package java_training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= {1,2,3};
		int arr1[]= {4,5,6};
		double median = 0.0;
		List<Integer> obj=new ArrayList<Integer>();
		
		for(int i:arr) {
			obj.add(i);
		}
		for(int k:arr1) {
			obj.add(k);
		}
		
		
		Collections.sort(obj);
		
		if(obj.size()%2!=0) {
			median=(obj.size()%2)+(obj.size()/2);
			System.out.println(median);
		}
		else {
			int first=obj.size()/2;
			int second=first-1;
			
			median=(obj.get(first)+obj.get(second))/2.0;
			System.out.println(median);
		}
	}

}
