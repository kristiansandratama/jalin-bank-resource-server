package com.jalin.resourceserver.module.dummy.repository;

import com.jalin.resourceserver.module.dummy.entity.Corporate;
import com.jalin.resourceserver.module.dummy.entity.CorporateTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorporateRepository extends JpaRepository<Corporate, String> {
    List<Corporate> findByCorporateTypeOrderByCorporateNameAsc(CorporateTypeEnum corporateType);
}
