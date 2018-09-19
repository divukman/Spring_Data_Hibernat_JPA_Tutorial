package com.dimitar.assignment.cusromerdata.cusromerdata;

import com.dimitar.assignment.cusromerdata.cusromerdata.entities.Customer;
import com.dimitar.assignment.cusromerdata.cusromerdata.repos.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CusromerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testSave() {
		final Customer customer = new Customer();
		customer.setName("John");
		customer.setEmail("john@someprovider.com");
		assert (customerRepository.save(customer) != null);
	}

	@Test
	public void testDelete() {
		final Customer customer = new Customer();
		customer.setName("William");
		customer.setEmail("will@someprovider.com");
		assert (customerRepository.save(customer) != null);

		final Long id = customer.getId();
		customerRepository.delete(customer);

		assert (false == customerRepository.existsById(id));
	}

	@Test
	public void testUpdate() {
		final Customer customer = new Customer();
		customer.setName("Deanna");
		customer.setEmail("deanna@someprovider.com");
		assert (customerRepository.save(customer) != null);

		final Long id = customer.getId();
		customer.setEmail("deanna@gmail.com");
		customerRepository.save(customer);

		Customer dbcustomer = customerRepository.findById(id).get();
		assert (dbcustomer.getEmail().equalsIgnoreCase("deanna@gmail.com"));
	}

}
