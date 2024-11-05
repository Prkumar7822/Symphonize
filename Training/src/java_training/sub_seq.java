package java_training;

public class sub_seq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s="abc";
		
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<s.length();j++) {
				for(int k=i;k<=j;k++) {
					System.out.println(s.charAt(i)+""+s.charAt(j));
				}
			}
		}
		

	}

}
