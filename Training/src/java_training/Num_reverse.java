package java_training;

public class Num_reverse {
	public int reverse(int x) {
        String sum="";
        int original=x;
        x=Math.abs(x);
        String s=String.valueOf(x);
        for(int i=0;i<s.length();i++){
            int rem=x%10;
            sum+=rem;
            x=x/10;
        }
        sum=sum.replaceAll("0", "");
        int sum1=Integer.parseInt(sum);
        if(original<0) {
        	sum1=-sum1;
        }
return sum1;
}
	
	public static void main(String[] args) {
		Num_reverse obj=new Num_reverse();
		int number=-5010;
		int p=obj.reverse(number);
		System.out.println(p);
	}
	
}