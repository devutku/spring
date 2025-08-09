package dev.patika.spring.dtos;

import dev.patika.spring.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequest {
    private int id;
    private String name;
    private Customer.GENDER gender;
}
