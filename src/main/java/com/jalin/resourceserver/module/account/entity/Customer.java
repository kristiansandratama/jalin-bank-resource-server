package com.jalin.resourceserver.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
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
    private String fullName;
    private String mobileNumber;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "customer",
            orphanRemoval = true)
    private Set<Account> accounts ;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date modifiedDate;

    public Customer(String fullName, String mobileNumber) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
    }
}
