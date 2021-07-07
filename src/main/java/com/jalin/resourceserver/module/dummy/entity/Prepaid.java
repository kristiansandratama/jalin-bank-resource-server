package com.jalin.resourceserver.module.dummy.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "prepaid_options")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Prepaid {
    @Id
    @GeneratedValue
    private UUID prepaidId;
    private String prepaidName;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private PrepaidTypeEnum prepaidType;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant modifiedDate;
}
