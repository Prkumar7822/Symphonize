package Details;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import Details.Show_functionalities;
public class Add_student {
	Scanner in=new Scanner(System.in);
	Map<Integer, Student> obj = new HashMap<>();
		int id = 1;
		public void Add() {
			  System.out.println("Enter Student Name:");
              String name = in.next(); 
              System.out.println("Enter Student Age:");
              int age = in.nextInt(); 
              System.out.println("Enter Student Grade:");
              String grade = in.next();
              obj.put(id,new Student(name,age,grade));
              System.out.println(name + " is saved successfully ");
              id++;
		}
		public void update() {
			System.out.println("Enter ID to update:");
            int updateId = in.nextInt();                   
            if (obj.containsKey(updateId)) {
                System.out.println("Enter new name:");
                String newName = in.next();
                System.out.println("Enter new Grade :");
                String newGrade=in.next();
                in.nextLine();
                System.out.println("Enter new Age");
                int newAge=in.nextInt();
                obj.put(updateId, new Student(newName,newAge,newGrade)); 
                System.out.println("Updated successfully to " + newName);
            } else {
                System.out.println("ID is not present in the data.");
            }
		}
            public void delete() {
            	System.out.println("Enter id to delete:");
                int deleteId = in.nextInt();
                if (obj.containsKey(deleteId)) {
                    obj.remove(deleteId);
                    System.out.println( deleteId + " is deleted successfully.");
                } else {
                    System.out.println("Invalid ID.");
                }
            }
            public void search() {
            	System.out.println("Enter ID to search:");
                int searchId = in.nextInt();
                for(Entry<Integer, Student> r:obj.entrySet()) {
                	Student student=r.getValue();

                	if(searchId==r.getKey()) {
                		System.out.println("Name :"+student.getName()+" Age :"+student.getAge()+" Grade :"+student.getGrade());
                	}
                	else {
                		System.out.println("Student id not found");
                	}
                }
            }
            
            public void getall() {
                if (obj.isEmpty()) {
                    System.out.println("No students in the record.");
                } else {
                    for (Entry<Integer, Student> entry : obj.entrySet()) {
                    	Student student=entry.getValue();
                        System.out.println("ID: " + entry.getKey() + " Name: "+student.getName()+" Age :"+student.getAge()+" Grade :"+student.getGrade());
                    }
                }
            }
		}

	

