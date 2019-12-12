package com.exercise45rest.services;

import java.util.ArrayList;
import java.util.Properties;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;

import java.io.IOException;
import java.io.InputStream;

import com.exercise45rest.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

@Path("/Products")
public class DAOProductsImpl implements DAOProducts {
	Connection conn=null;
	PreparedStatement pstmnt=null;
	ResultSet rs=null;
	int rowsAffected=0;
	String sqlSentence="";
	Properties props = new Properties();
	InputStream in = this.getClass().getClassLoader().getResourceAsStream("dao.properties");
	
	public Connection getConnection()
	{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean SaveProduct(Product myProduct) {
		conn = getConnection();
		try
		{
			props.load(in);
			if(props!=null)
			{
				sqlSentence = props.getProperty("SQLSaveProduct");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			pstmnt = conn.prepareStatement(sqlSentence);
			pstmnt.setString(1, myProduct.getNameProduct());
			pstmnt.setDouble(2, myProduct.getPriceProduct());
			rowsAffected = pstmnt.executeUpdate();
			System.out.println("Product Added to Database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmnt.close();
				conn.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return (rowsAffected>0)?true:false;
	}

	@Override
	public boolean UpdateProduct(int idProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean DeleteProduct(int idProduct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product ReadProduct(int idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Product> ReadAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

}
