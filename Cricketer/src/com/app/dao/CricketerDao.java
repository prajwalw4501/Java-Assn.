package com.app.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;

import com.app.core.Cricketer;
import com.app.exception.InvalidIdException;

public interface CricketerDao {

	public String updateRating(String email, int rating, HashMap<String, Cricketer> cmap) throws InvalidIdException;

	public Cricketer searchCricketer(String name, HashMap<String, Cricketer> cmap) throws InputMismatchException;

	public void writeDetails(String name, HashMap<String, Cricketer> cmap) throws IOException, FileNotFoundException;

	public void readDetails(String file) throws FileNotFoundException, IOException;
}
