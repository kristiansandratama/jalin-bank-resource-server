package com.jalin.resourceserver.module.account.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GenericGenerator(
            name = "transactionId",
            strategy = "com.jalin.resourceserver.module.account.entity.IdGenerator")
    @GeneratedValue(generator = "transactionId")
    private String transactionId;
    private LocalDate transactionDate;
    private String transactionType;
    private String currency;
    private BigDecimal amount;
    private String transactionName;
    private String transactionDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    private Account account;
    @CreationTimestamp
    private Instant createdDate;
}
