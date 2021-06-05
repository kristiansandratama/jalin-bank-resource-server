package com.jalin.resourceserver.module.account.repository;

import com.jalin.resourceserver.module.account.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, UUID> {
    Optional<AccountDetails> findByMobileNumber(String mobileNumber);
}
