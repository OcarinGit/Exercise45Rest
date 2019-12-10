package com.exercise45rest.services;

import java.util.ArrayList;
import com.exercise45rest.model.Customer;

public interface DAOCustomer {
	public void SaveCustomer(Customer myCustomer);
	public boolean UpdateCustomer(Customer myCustomer);
	public boolean DeleteCustomer(int idCustomer);
	public Customer ReadCustomer(int idCustomer);
	public ArrayList<Customer> ReadAllCustomer();
}
