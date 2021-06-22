package com.jalin.resourceserver.module.dummy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant modifiedDate;
}
