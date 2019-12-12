package com.exercise45rest.services;

import com.exercise45rest.model.Product;
import java.util.ArrayList;

public interface DAOProducts {
	public boolean SaveProduct(Product myProduct);
	public boolean UpdateProduct(int idProduct);
	public boolean DeleteProduct(int idProduct);
	public Product ReadProduct(int idProduct);
	public ArrayList<Product> ReadAllProduct();
}
