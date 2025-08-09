package dev.patika.spring.api.v1;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dtos.CustomerResponse;
import dev.patika.spring.dtos.CustomerSaveRequest;
import dev.patika.spring.dtos.CustomerUpdateRequest;
import dev.patika.spring.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll() {
//        List<Customer> customers = customerService.findAll();
//        List<CustomerDto> customerDtoList = customers.stream().map(
//                customer -> this.converter.convertDto(customer)
//        ).collect(Collectors.toList());
        List<CustomerResponse> customerResponseList = this.customerService.findAll().stream().map(
                customer -> this.modelMapper.map(customer, CustomerResponse.class)
        ).collect(Collectors.toList());
        return customerResponseList;
    }


    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        Customer customer = this.modelMapper.map(customerSaveRequest, Customer.class);
        customer.setOnDate(LocalDate.now());
        return this.customerService.save(customer);
    }


    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = this.customerService.getById(customerUpdateRequest.getId());
        customer.setName(customerUpdateRequest.getName());
        customer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(customer);
    }


    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        this.customerService.delete(id);
    }


    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") int id) {
        return this.modelMapper.map(this.customerService.getById(id), CustomerResponse.class);
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
