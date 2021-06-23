package com.jalin.resourceserver.module.dummy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "corporates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Corporate {
    @Id
    private String corporateId;
    private String corporateName;
    @Enumerated(EnumType.STRING)
    private CorporateTypeEnum corporateType;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant modifiedDate;
}
