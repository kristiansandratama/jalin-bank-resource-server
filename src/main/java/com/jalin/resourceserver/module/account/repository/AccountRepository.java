package com.jalin.resourceserver.module.account.repository;

import com.jalin.resourceserver.module.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
