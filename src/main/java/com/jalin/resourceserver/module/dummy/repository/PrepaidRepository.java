package com.jalin.resourceserver.module.dummy.repository;

import com.jalin.resourceserver.module.dummy.entity.Prepaid;
import com.jalin.resourceserver.module.dummy.entity.PrepaidTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PrepaidRepository extends JpaRepository<Prepaid, UUID> {
    List<Prepaid> findByPrepaidTypeOrderByPriceAsc(PrepaidTypeEnum prepaidType);
}
