package com.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.enums.ServicePlan;

import customerpackage.CustomerField;

public class PopulatedData {
	 public static List<CustomerField> populatedData() {
		 
	        CustomerField c1 = new CustomerField("Pranay", "Jumde", "p@gmail.com", "123"
	                , LocalDate.parse("1999-08-08"), ServicePlan.valueOf("GOLD"),2000);
	        CustomerField c2 = new CustomerField("Ayush", "Gupta", "a@gmail.com", "123",
	                 LocalDate.parse("1999-08-08"), ServicePlan.valueOf("GOLD"),2000);
	        CustomerField c3 = new CustomerField("Karshin", "Sinha", "k@gmail.com", "123"
	                 ,LocalDate.parse("2001-11-12"), ServicePlan.valueOf("GOLD"),2000);
	        CustomerField c4 = new CustomerField("Sai", "Kakde", "s@gmail.com", "123",
	                 LocalDate.parse("2001-11-12"), ServicePlan.valueOf("GOLD"),2000);
	        CustomerField c5 = new CustomerField("Prajwal", "Wandhare", "pw@gmail.com", "123",
	                 LocalDate.parse("2000-02-02"), ServicePlan.valueOf("GOLD"),2000);
	        CustomerField c6=new CustomerField("Pranay", "Jumde", "p@gmail.com", "asd",
	        		LocalDate.parse("1999-08-08"), ServicePlan.valueOf("GOLD"),2000);

	        List<CustomerField> customerList = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5,c6));
	        /// Because of Arrays.asList() it created constant array and iterator throws exception saying Unsupported
	        // So we have to create growable arraylist.

	        return customerList;
	    }

}
