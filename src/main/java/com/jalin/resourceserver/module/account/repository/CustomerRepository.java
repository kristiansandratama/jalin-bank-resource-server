package com.jalin.resourceserver.module.account.repository;

import com.jalin.resourceserver.module.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
