package dev.patika.spring.dtos;

import dev.patika.spring.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// Pojo
public class CustomerResponse {
    private int id;
    private String name;
    private String mail;
    private Customer.GENDER gender;
}
