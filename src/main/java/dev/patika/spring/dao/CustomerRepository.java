package dev.patika.spring.dao;

import dev.patika.spring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepository , JPARepository ,
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByMail(String mail);
    Customer findByMailAndGender(String mail, Customer.GENDER gender);
    List<Customer> findByGender(Customer.GENDER gender);
    @Query("FROM Customer as c where c.gender =:gender")
    List<Customer> getQueryByGender(@Param("gender") Customer.GENDER gender);
}
