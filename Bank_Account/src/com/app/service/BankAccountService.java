package com.app.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.app.entites.BankAccount;

public class BankAccountService {

	
	
public static List<BankAccount>  readFile(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		

		
		List<BankAccount> bankaccount = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // Read header line

            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                if (values.length == 4) {
                    String transactionDate = values[0].trim();
                    String narration = values[1].trim();
                    double withdrawalAmount = Double.parseDouble(values[2].trim());
                    double depositAmount = Double.parseDouble(values[3].trim());

                    bankaccount.add(new BankAccount(LocalDate.parse(transactionDate), 
                    		narration, withdrawalAmount, depositAmount));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return bankaccount;
		
		
		
	}

public static double SumofDeposite(List<BankAccount> list2) {
	double sum=0;
	for(BankAccount bank:list2) {
		sum+=bank.getDepositAmount();
	}
	
	return sum;
	
}

public static double MaxDeposite(List<BankAccount> list2) {
	double max=0;
	for(BankAccount bank:list2) {
		if(bank.getDepositAmount()>max) {
			max=bank.getDepositAmount();
		}
	}
	return max;
}
public static double Shopingexpainse(List<BankAccount> list2) {
	double sum=0;
	for(BankAccount bank:list2) {
		if(bank.getNarration().equals("Shopping")) {
			sum+=bank.getWithdrawalAmount();
		}
	}
	return sum;
}
public static LocalDate maxWithdrowsDate(List<BankAccount> list2) {
	LocalDate date = null;
	double max=0;
	 
	for(BankAccount bank:list2) {
		if(bank.getWithdrawalAmount()>max) {
			max=bank.getDepositAmount();
			date=bank.getTransactionDate();
		}
	}
	return date;
}

	
}
