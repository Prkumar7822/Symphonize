package Details;
import java.util.Scanner;
public class Show_functionalities {
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(true) {
			
			System.out.println("1.Add Student");
			
			System.out.println("2.Update student");
			
			System.out.println("3.Deleting student");
			
			System.out.println("4.Searching for student");
			
			System.out.println("5.Displaying all students");
			int option=in.nextInt();
			
			switch(option) {
			case 1:{
				Add_student obj=new Add_student();
				obj.Add();
			}
			
			
			
			}
			
		}
			
	
	
	}
	
	
}
