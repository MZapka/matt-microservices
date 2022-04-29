package mz.zapps.services.customer.service;

import java.util.List;

import mz.zapps.services.customer.repository.CustomerRepository;
import mz.zapps.services.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {


//	private KafkaMessageProducer  producer;

    // INITIALIZE REPO
    @Autowired
    private CustomerRepository customerRepository;

    // CONSTRUCTOR
    public CustomerService(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    // SETTERS & GETTERS
    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }



//	public KafkaMessageProducer getProducer() {
//		return producer;
//	}
//
//	public void setProducer(KafkaMessageProducer producer) {
//		this.producer = producer;
//	}

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // ADD CUSTOMER (CREATE)
    public Customer add(Customer customer) {

        customer =	customerRepository.save(customer);

        if (customer instanceof  Customer) {
            //producer
//			producer.sendCustomCustomer("userLogin", customer);
        }
        else {
            System.out.println("Customer does not exist");
        }


        return customer;
    }

    // FIND ALL CUSTOMERS (READ)
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    // FIND SPECIFIC CUSTOMER (READ)
    public Customer findSpecificCustomer(Long customerId) {
        return customerRepository.findById(customerId).get();
    }

    // UPDATE CUSTOMER
    public void update(Long customerId, String companyName, String contactName, String street, String city,
                       String state, int zipCode) {
        // CHECK IF CURRENT CUSTOMER EXISTS
        if (customerRepository.findById(customerId).isPresent()) {
            // FIND EXISTING CUSTOMER
            Customer existingCustomer = customerRepository.findById(customerId).get();
            // UPDATE VALUES
            existingCustomer.setCompanyName(companyName);
            existingCustomer.setContactName(contactName);
            existingCustomer.setStreet(street);
            existingCustomer.setCity(city);
            existingCustomer.setState(state);
            // SAVE UPDATED VALUES
            customerRepository.save(existingCustomer);

        }
        else {
            System.out.println("Customer does not exist");
        }

    }

    // DELETE CUSTOMER
    public void delete(Long customerId) {
        customerRepository.deleteById(customerId);
    }



}
