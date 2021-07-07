package com.jalin.resourceserver.seeder;

import com.jalin.resourceserver.module.dummy.entity.Prepaid;
import com.jalin.resourceserver.module.dummy.entity.PrepaidTypeEnum;
import com.jalin.resourceserver.module.dummy.repository.PrepaidRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
@Order(value = 3)
@Slf4j
public class PrepaidSeeder implements CommandLineRunner {
    @Autowired
    private PrepaidRepository prepaidRepository;

    @Override
    public void run(String... args) {
        try {
            seed();
        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }

    @Transactional
    private void seed() {
        if (prepaidRepository.count() == 0) {
            Prepaid prepaid5 = new Prepaid();
            prepaid5.setPrepaidName("Pulsa 5.000");
            prepaid5.setPrice(new BigDecimal("6000"));
            prepaid5.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid5);

            Prepaid prepaid10 = new Prepaid();
            prepaid10.setPrepaidName("Pulsa 10.000");
            prepaid10.setPrice(new BigDecimal("11000"));
            prepaid10.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid10);

            Prepaid prepaid15 = new Prepaid();
            prepaid15.setPrepaidName("Pulsa 15.000");
            prepaid15.setPrice(new BigDecimal("16000"));
            prepaid15.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid15);

            Prepaid prepaid25 = new Prepaid();
            prepaid25.setPrepaidName("Pulsa 25.000");
            prepaid25.setPrice(new BigDecimal("26000"));
            prepaid25.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid25);

            Prepaid prepaid30 = new Prepaid();
            prepaid30.setPrepaidName("Pulsa 30.000");
            prepaid30.setPrice(new BigDecimal("31000"));
            prepaid30.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid30);

            Prepaid prepaid50 = new Prepaid();
            prepaid50.setPrepaidName("Pulsa 50.000");
            prepaid50.setPrice(new BigDecimal("50000"));
            prepaid50.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid50);

            Prepaid prepaid75 = new Prepaid();
            prepaid75.setPrepaidName("Pulsa 75.000");
            prepaid75.setPrice(new BigDecimal("75000"));
            prepaid75.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid75);

            Prepaid prepaid100 = new Prepaid();
            prepaid100.setPrepaidName("Pulsa 100.000");
            prepaid100.setPrice(new BigDecimal("100000"));
            prepaid100.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid100);

            Prepaid prepaid150 = new Prepaid();
            prepaid150.setPrepaidName("Pulsa 150.000");
            prepaid150.setPrice(new BigDecimal("150000"));
            prepaid150.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid150);

            Prepaid prepaid200 = new Prepaid();
            prepaid200.setPrepaidName("Pulsa 200.000");
            prepaid200.setPrice(new BigDecimal("200000"));
            prepaid200.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
            prepaidRepository.save(prepaid200);
        }
    }
}
