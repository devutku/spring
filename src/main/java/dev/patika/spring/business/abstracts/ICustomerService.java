package dev.patika.spring.business.abstracts;


import dev.patika.spring.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ICustomerService {
    Customer getById(int id);
    Customer save(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
}
