package com.exercise45rest.services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.exercise45rest.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("/Customer")
public class DAOCustomerImpl implements DAOCustomer {

	Connection conn = null;
	PreparedStatement pstmnt = null;
	ResultSet rs = null;
	
	private Connection getConnection()
	{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		//conn = ConnectionFactory.getConnection();
		return conn;
	}
	
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void SaveCustomer(Customer myCustomer) {
		String sentenciaSQL = "INSERT INTO Customer (nameCustomer, addressCustomer, ageCustomer, heightCustomer, weightCustomer, isSingle) VALUES (?,?,?,?,?,?)";
		conn = getConnection();
		
		try {
			pstmnt = conn.prepareStatement(sentenciaSQL);
			pstmnt.setString(1, myCustomer.getNameCustomer());
			pstmnt.setString(2, myCustomer.getAddressCustomer());
			pstmnt.setInt(3, myCustomer.getAgeCustomer());
			pstmnt.setDouble(4, myCustomer.getHeightCustomer());
			pstmnt.setDouble(5, myCustomer.getWeightCustomer());
			pstmnt.setBoolean(6, myCustomer.isSingle());
			pstmnt.executeUpdate();
			System.out.println("Record Added to Database!!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				pstmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

	@Override
	public boolean UpdateCustomer(Customer myCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteCustomer(int idCustomer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer ReadCustomer(int idCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> ReadAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
