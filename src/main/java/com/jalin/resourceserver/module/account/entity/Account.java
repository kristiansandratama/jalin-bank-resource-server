package com.jalin.resourceserver.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {
    @Id
    @GenericGenerator(
            name = "accountNumber",
            strategy = "com.jalin.resourceserver.module.account.entity.AccountNumberGenerator")
    @GeneratedValue(generator = "accountNumber")
    private String accountNumber;
    private String currency;
    private BigDecimal balance;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date modifiedDate;

    public Account(String currency, BigDecimal balance) {
        this.currency = currency;
        this.balance = balance;
    }
}
