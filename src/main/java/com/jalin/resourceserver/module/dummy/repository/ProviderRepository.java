package com.jalin.resourceserver.module.dummy.repository;

import com.jalin.resourceserver.module.dummy.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, String> {
    Optional<Provider> findByPrefixNumber(String prefixNumber);
}
