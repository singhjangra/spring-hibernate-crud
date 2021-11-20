/**
 * 
 */
package djh.learn.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import djh.learn.dao.CustomerDao;
import djh.learn.entity.Customer;

/**
 * @author Sunil Jangra
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		System.out.println("Entering in the Service method......");
		return customerDao.getAllCustomers();
	}

	@Override
	@Transactional
	public void addCustomer(Customer myCustomer) {
		// TODO Auto-generated method stub
		customerDao.addMyCustomer(myCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		// TODO Auto-generated method stub
		 customerDao.delete(customerId);
	}

}
