package djh.learn.dao;

import java.util.List;

import djh.learn.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> getAllCustomers();

	public void addMyCustomer(Customer myCustomer);

	public Customer getCustomerById(Integer id);

	public void delete(int customerId);
}
