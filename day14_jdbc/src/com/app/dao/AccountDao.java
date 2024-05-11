package com.app.dao;
import java.sql.SQLException;

public interface AccountDao {

	String transferFunds(int scrAcno, int destacno, double amount) throws SQLException;
//add a method for invoking a stored proc. from DB, to transfer funds
	String transferFunds2(int scrAcno, int destacno, double amount) throws SQLException;
}
