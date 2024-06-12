package com.app.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.entites.BankAccount;
import com.app.service.BankAccountService;

public class BankAccountTester {

	public static void main(String[] args) {

		int choice;
		Scanner sc = new Scanner(System.in);

		BankAccount account;
		List<BankAccount> list=new ArrayList<BankAccount>();
		List<BankAccount> list1=new ArrayList<BankAccount>();
		do {
			System.out.println("2. display all\n" + "3. Sum of all deposits\n"
					+ "4.Max deposit amount\n" + "5.Shopping expenses (sum of withdrawals for shopping)\n"
					+ "6.Date on which maximum amount withdrawn\n" + "10.exit\n");
			System.out.println("enter choice. \n");
			choice = sc.nextInt();

			try {
				switch (choice) {
				
				case 1:
					//LocalDate transactionDate, String narration, 
					//double withdrawalAmount, double depositAmount
//					System.out.println("enter transcation date , narration, withdrowamount, deposite amount");
//					account=new BankAccount(LocalDate.parse(sc.next()), sc.next(), sc.nextDouble(), sc.nextDouble());
//					list.add(account);
//					System.out.println("-------Added Succesfull-------\n");
//					
//					System.out.println("Enter file name \n");
//					BankAccountService.writeFile(sc.next(),list);
//					break;
//					
				
				case 2:
					System.out.println("Enter file name \n");
					list1=BankAccountService.readFile(sc.next());
					
					System.out.println("-------Displaying all bank Account-------\n");
					list1.forEach(i->System.out.println(i));
					break;
				
				case 3:
					System.out.println("----------------------");
					double sum=BankAccountService.SumofDeposite(list1);
					System.out.println("Sum of all deposits = " +sum );
					break;
					
				case 4:
					System.out.println("----------------------");
					double max=BankAccountService.MaxDeposite(list1);
					System.out.println("Maximun of all deposits = " +max );
					break;
					
				case 5:
					
					System.out.println("----------------------");
					double sum1=BankAccountService.Shopingexpainse(list1);
					System.out.println("Sum of all deposits = " +sum1 );
					break;
					
				case 6:
					
					System.out.println("----------------------");
					LocalDate date=BankAccountService.maxWithdrowsDate(list1);
					System.out.println("Date of maximum withdrow done = " +date );
					break;
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} while (choice != 10);

	}

}
