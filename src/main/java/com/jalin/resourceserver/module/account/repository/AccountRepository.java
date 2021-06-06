package com.jalin.resourceserver.module.account.repository;

import com.jalin.resourceserver.module.account.entity.Account;
import com.jalin.resourceserver.module.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByCustomer(Customer customer);
}
