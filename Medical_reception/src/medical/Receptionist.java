package medical;

import java.util.Scanner;

public class Receptionist {

	public static void main(String[] args) throws mycustomException {
		
		int id=1;
			
		PatientManager obj=new PatientManager();
		Scanner in=new Scanner(System.in);
		while(true) {
			System.out.println("menu");
			
			System.out.println("1.Add patient :");
			
			System.out.println("2.Balance enquiry :");
			
			System.out.println("3.patient enquiry :");
			
			System.out.println("Enter your option");
			int choice = in.nextInt();
			
			
			switch(choice) {
			
			case 1:{
				obj.addPatient();
				break;
			}
			case 2:{
				obj.balanceEnquire();
				break;
			}
			case 3:{
				obj.payBills();
				break;
			}
			
			
			
			}
			
			
		}
		
	}

}
