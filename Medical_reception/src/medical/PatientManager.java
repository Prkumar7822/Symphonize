package medical;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class PatientManager {
    private Scanner in = new Scanner(System.in);
    private Map<Integer, Data> patientRecords = new HashMap<>();
    private int id = 1;

    public void addPatient() {
        System.out.println("Enter patient name:");
        String patientName = in.nextLine();
        System.out.println("Enter disease name:");
        String disease = in.nextLine();
        System.out.println("Enter amount due:");
        int amount = in.nextInt();
        in.nextLine(); 

        patientRecords.put(id, new Data(patientName, disease, amount));
        System.out.println("Patient added with ID: " + id);
        id++;
    }

        public void balanceEnquire() throws mycustomException {
        System.out.println("Enter patient full name:");
        String pname = in.nextLine();
        boolean found = false;

        for (Data data : patientRecords.values()) {
            if (data.getPname().equalsIgnoreCase(pname)) {
                System.out.println("Name: " + data.getPname() + " | Disease: " + data.getDisease() + " | Balance Payment: " + data.getAmount());
                found = true;
                break;
            }
        }
        
        if (!found) {
            throw new mycustomException("Patient not found");
        }
    }

    public void payBills() {
        System.out.println("Enter patient ID:");
        int patientId = in.nextInt();
        in.nextLine(); 
        
        Data data = patientRecords.get(patientId);
        
        if (data != null) {
            System.out.println("Your balance is " + data.getAmount());
            System.out.println("Pay by 'card' or 'cash':");
            String paymentMethod = in.nextLine();
            int due=data.getAmount();
            if (paymentMethod.equalsIgnoreCase("card")) {
                System.out.println("Enter card number:");
                long cardNumber = in.nextLong();
                System.out.println("Enter PIN:");
                int pin = in.nextInt();
                in.nextLine();  
                
                System.out.println("Payment successful!");
                data.setAmount(0);  
            } else if (paymentMethod.equalsIgnoreCase("cash")) {
            	
            	int givencas=in.nextInt();
            	
            	if(givencas==due) {
                    System.out.println("Cash payment accepted. Payment successful!");
                    data.setAmount(0); 

            	}
            	else if(givencas>due) {
            		int change=givencas-due;
            		System.out.println("Take your change "+change);
            	}
            	
            } else {
                System.out.println("Invalid payment method. Please try again.");
            }
        } else {
            System.out.println("Patient ID not found.");
        }
    }
}
