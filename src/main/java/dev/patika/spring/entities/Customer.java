package dev.patika.spring.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "customer_id")
    private int id; //customer_id

    @Column(name = "customer_name",length = 100,nullable = false)
    private String name;

    @Column(name = "customer_mail",unique = true)
    private String mail;

    @Temporal(TemporalType.DATE)
    @Column(name = "customer_on_date")
    private LocalDate onDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_gender")
    private GENDER gender;

    public enum GENDER {
        MALE, FEMALE, OTHER;

    }
}
