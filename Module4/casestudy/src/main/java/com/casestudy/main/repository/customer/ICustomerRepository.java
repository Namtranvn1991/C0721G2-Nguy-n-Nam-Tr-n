package com.casestudy.main.repository.customer;

import com.casestudy.main.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);

    @Query(value="select * from customer where match(customer_name,customer_id_card,customer_email,customer_phone,customer_address) against (?1)", nativeQuery=true)
    Page<Customer> search(String keyword,Pageable pageable);

    Boolean existsByCustomerEmail(String email);
    Boolean existsByCustomerPhone(String phone);
    Boolean existsByCustomerIdCard(String idCard);
}
