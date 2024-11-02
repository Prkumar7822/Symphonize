package Details;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Assessment {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, Student> obj = new HashMap<>();
        int id = 1;
        Add_student obj1=new Add_student();
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search for Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.println("Enter your option :");

            int option = in.nextInt();
            in.nextLine(); 

            switch (option) {
                case 1: {
                   obj1.Add();
                    break;
                }
                case 2: {
                    obj1.update();
                    break;
                }
                case 3: {
                    obj1.delete();
                    break;
                }
                case 4: {
                    obj1.search();
                    break;
                }
                case 5: {
                    obj1.getall();
                    break;
                }
                case 6: {
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    return;
                }
                default :{
                	System.err.println("Invalid option");
                }
            
                }
            }
        }
    
}
