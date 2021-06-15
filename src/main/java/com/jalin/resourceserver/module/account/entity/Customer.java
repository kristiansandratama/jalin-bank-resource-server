package com.jalin.resourceserver.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private UUID customerId;
    private String idCardNumber;
    private String fullName;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private Set<Account> accounts ;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant modifiedDate;

    public Customer(String idCardNumber, String fullName) {
        this.idCardNumber = idCardNumber;
        this.fullName = fullName;
    }
}
