package com.cust_exception;
import java.util.*;

public class InvalidCredits extends Exception{

	public InvalidCredits(String msg) {
		super(msg);
	}
	
}