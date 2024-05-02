package customerpackage;
import java.util.*;
import java.util.Scanner;

public class CMSTester {

	public static void main(String[] args) {
		try (Scanner sc= new Scanner(System.in)){
		System.out.println("Enter total no. of Customers to ADD: ");
		CustomerField[] cust = new CustomerField[sc.nextInt()];
		System.out.println("===MENU=== \n1.Sign UP \n2.Sign IN \n3.Change Password: "
				+ "\n4. Unscribe Customer \n5.Display Customers ");
		System.out.println("Choose the Valid Option: ");
		int choice=sc.nextInt();
		try {
			switch(choice) {
			case 1:
				System.out.println("Enter Customer Details: "
						+ "\nCustomer ID: "+CustomerField.getCustomerid()+
						"\nEmail: ");
				
			}
		}
		}
//	sc.close();
	}
		
		

	


