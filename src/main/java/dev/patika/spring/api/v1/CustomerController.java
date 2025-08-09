package dev.patika.spring.api.v1;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAll() {
        return this.customerService.findAll();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }

    /*
    //Setter
    @Autowired
    private ICustomerService customerService;

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
     */
    /*
    //Field
    @Autowired
    private ICustomerService customerService;
     */


    /*
    @GetMapping("/")
    public String get() {
        return "Customer Get Çalıştı";
    }
    */
    /*
    @PostMapping("/save")
    public String save(@RequestBody String data) {
        return "Gelen veri : " + data;
    }
    */
    /*
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
    */
}
