package com.jalin.resourceserver.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "account_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDetails {
    @Id
    @GeneratedValue
    private UUID accountDetailsId;
    private String fullName;
    private String mobileNumber;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private Account account;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date modifiedDate;

    public AccountDetails (String fullName, String mobileNumber) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
    }
}
