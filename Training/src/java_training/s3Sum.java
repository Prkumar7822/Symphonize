package java_training;

public class s3Sum {

	public static void main(String[] args) {
		
		int arr[]= {1,-1,0,2,-2,3};
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				for(int k=j+1;k<arr.length;k++) {
					
					if(arr[i]+arr[j]+arr[k]==0) {
						System.out.print(arr[i]+","+arr[j]+","+arr[k]);
					}
				}
			}
			System.out.println();

		}
		


	}

}
