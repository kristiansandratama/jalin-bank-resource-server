package com.jalin.resourceserver.module.account.entity.model;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Date;

public class AccountNumberGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(
            SharedSessionContractImplementor sharedSessionContractImplementor,
            Object o) throws HibernateException {
        Date date = new Date();
        String generatedId = String.format("%tQ", date);
        return generatedId;
    }
}
