package customerpackage;

import static com.utility.SignUp.registration;

import java.util.ArrayList;
import java.util.Scanner;

import com.utility.SignIn;
import com.utility.Utilities;

public class CMSTest {

	public static void main(String[] args) {
		ArrayList<CustomerField> cust = new ArrayList<>();
		try (Scanner sc = new Scanner(System.in)) {
//		System.out.println("Enter total no. of Customers to ADD: ");
			boolean exit = false;
			do {

				System.out.println("===HELLO=== \n1.Sign UP \n2.Display Details \n3.Sign IN \n4.Change Password: "
						+ "\n5. Unscribe Customer \n6.Sort with D.O.B. \7.EXIT");
				System.out.println("Choose the Valid Option: ");
				int choice = sc.nextInt();
				try {
					switch (choice) {
					case 1:// Registration
						System.out.println("===Enter Customer Details to Register:=== ");
						registration(cust, sc);
						break;
					case 2:// display
						for (CustomerField c : cust)
							System.out.println(c);
						break;
					case 3:// log in
						System.out.println("Enter Details to LogIn: ");
						System.out.println("Enter Email ID: ");
						String email = sc.next();
						System.out.println("Enter Password: ");
						String password = sc.next();
						SignIn.logIn(cust, email, password);
						System.out.println("Successfully LogIn!!");
//				CustomerValidation.dupCustomer(email, cust);

						break;
					case 4:// change password
						System.out.println("Enter Email: ");
						String mail = sc.next();
						Utilities.checkEmail(cust, mail);
						System.out.println("Enter Current Password: ");
						String pass = sc.next();
						System.out.println("Enter New-Password: ");
						String newpass = sc.next();
						Utilities.changePassword(cust, mail, newpass);
						break;
					case 5:// unsubscribe
						System.out.println("Enter Email: ");
						String maill = sc.next();
						Utilities.unSubscribe(cust, maill);

						break;
					case 6://
						System.out.println("EXIT!!!");
						exit = true;
						break;

					}
				} catch (Exception e) {
					System.out.println(e);
					// read off all the pending tokens from the Scanner's buffer till new line
					sc.nextLine();
				}
			} while (!exit);
		}
	}
}
