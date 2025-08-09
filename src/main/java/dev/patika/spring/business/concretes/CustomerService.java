package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dao.CustomerRepository;
import dev.patika.spring.entities.Customer;

public class CustomerService implements ICustomerService {
    CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }
}
