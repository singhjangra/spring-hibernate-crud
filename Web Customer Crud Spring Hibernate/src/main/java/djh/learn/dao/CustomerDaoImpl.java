package djh.learn.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import djh.learn.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory factory;

	@Transactional
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		System.out.println("Entering in the Dao method......");
		Query<Customer> query = session.createQuery("from Customer order by lastName",Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public void addMyCustomer(Customer myCustomer) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		System.out.println("Entering in the Dao method......");
		session.saveOrUpdate(myCustomer);
		System.out.println("Data Saved Successfully.....");
	}

	@Override
	@Transactional
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		System.out.println("Entering in the Dao method......");
		Customer customer = session.get(Customer.class,id);
		System.out.println("Customer by Id ......"+customer);
		return customer;
	}

	@Override
	@Transactional
	public void delete(int customerId) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		System.out.println("Entering in the Dao method......");
	//	Query<Customer> query = session.createQuery("delete from Customer c where c.id=:customerId",Customer.class);
	//	query.setParameter("customerId", customerId);
	//	query.executeUpdate();
		Customer cust = session.get(Customer.class, customerId);
		session.remove(cust);
		System.out.println("Customer deleted Id ......");
	}
}
