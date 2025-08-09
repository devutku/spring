package dev.patika.spring.api;

import dev.patika.spring.entities.Customer;
import dev.patika.spring.dao.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/")
    public String get() {
        return "Customer Get Çalıştı";
    }
    /*
    @PostMapping("/save")
    public String save(@RequestBody String data) {
        return "Gelen veri : " + data;
    }*/
    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") Integer id) {
        return this.customerRepository.findById(id).orElseThrow();
    }
    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }
    @GetMapping("/find-all")
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }
    @GetMapping("/mail/{mail}")
    public Customer findByMail(@PathVariable("mail") String mail) {
        return this.customerRepository.findByMail(mail);
    }
    @GetMapping("/find/{mail}/{gender}")
    public Customer findByMailAndGender(@PathVariable("mail") String mail, @PathVariable("gender") Customer.GENDER gender) {
        return this.customerRepository.findByMailAndGender(mail,gender);
    }
    @GetMapping("/find/{gender}")
    public List<Customer> findByGender(@PathVariable("gender") Customer.GENDER gender) {
        return this.customerRepository.findByGender(gender);
    }
}
