package com.app.dao;

import static com.app.utils.DBUtils.closeConnection;
import static com.app.utils.DBUtils.openConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AccountDaoImpl implements AccountDao {
//state
	private Connection cn;
	private CallableStatement cst1,cst2;

	// def ctor
	public AccountDaoImpl() throws SQLException {
		// get db connection from db utils
		cn = openConnection();
		// create CST to invoke stored proc
		cst1 = cn.prepareCall("{call transfer_funds_proc(?,?,?,?,?)}");
		// register out params
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("source");
		cst2=cn.prepareCall("{?=call transfer_funds_func(?,?,?)}");
		cst2.registerOutParameter(1, Types.DOUBLE);
	}

	

	public void cleanUp() throws SQLException {
		if (cst1 != null)
			cst1.close();
		closeConnection();
	}

	@Override
	public String transferFunds(int scrAcno, int destacno, double amount) throws SQLException {

		cst1.setInt(1, scrAcno);
		cst1.setInt(2, destacno);
		cst1.setDouble(3, amount);
		cst1.execute();
		return "Source" + cst1.getDouble(4) + "Destination" + cst1.getDouble(5);

	}



	@Override
	public String transferFunds2(int scrAcno, int destacno, double amount) throws SQLException {
		cst2.setInt(2, scrAcno);
		cst2.setInt(3, destacno);
		cst2.setDouble(4, amount);
		cst2.execute();
		return "Update"+cst2.getDouble(1);
	}
}
