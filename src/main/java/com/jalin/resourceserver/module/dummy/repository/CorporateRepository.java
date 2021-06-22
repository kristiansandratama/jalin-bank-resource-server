package com.jalin.resourceserver.module.dummy.repository;

import com.jalin.resourceserver.module.dummy.entity.Corporate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, String> {
}
