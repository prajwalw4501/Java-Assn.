package com.cust_exception;

import java.util.*;

public class InvalidEmail extends Exception{
     public InvalidEmail(String msg) {
	 super(msg);
     }
}