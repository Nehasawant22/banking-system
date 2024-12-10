package com.banking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	Optional<Customer> findByEmailId(String emailId);

}
