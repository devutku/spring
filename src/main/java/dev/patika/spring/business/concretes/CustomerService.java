package dev.patika.spring.business.concretes;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dao.CustomerRepository;
import dev.patika.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private  CustomerRepository customerRepository;

    @Override
    public Customer getById(int id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.delete(this.getById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
}
