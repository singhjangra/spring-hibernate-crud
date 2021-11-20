package djh.learn.service;

import java.util.List;

import djh.learn.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void addCustomer(Customer myCustomer);

	public Customer getCustomerById(Integer id);

	public void delete(int customerId);

}
