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

            Prepaid prepaidData250 = new Prepaid();
            prepaidData250.setPrepaidName("Data Flash 250MB");
            prepaidData250.setPrepaidDetails("all network + bebas zona, 7 hari, 250MB");
            prepaidData250.setPrice(new BigDecimal("10500"));
            prepaidData250.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData250);

            Prepaid prepaidData500 = new Prepaid();
            prepaidData500.setPrepaidName("Data Flash 500MB");
            prepaidData500.setPrepaidDetails("all network + bebas zona, 7 hari, 500MB");
            prepaidData500.setPrice(new BigDecimal("13500"));
            prepaidData500.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData500);

            Prepaid prepaidData750 = new Prepaid();
            prepaidData750.setPrepaidName("Data Flash 750MB");
            prepaidData750.setPrepaidDetails("all network + bebas zona, 7 hari, 750MB");
            prepaidData750.setPrice(new BigDecimal("17900"));
            prepaidData750.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData750);

            Prepaid prepaidData2000 = new Prepaid();
            prepaidData2000.setPrepaidName("Data Flash 2GB");
            prepaidData2000.setPrepaidDetails("all network + bebas zona, 7 hari, 2GB");
            prepaidData2000.setPrice(new BigDecimal("36000"));
            prepaidData2000.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData2000);

            Prepaid prepaidData7Days30 = new Prepaid();
            prepaidData7Days30.setPrepaidName("Internet OMG 30rb/7 hari");
            prepaidData7Days30.setPrepaidDetails("all network + bebas zona, 7 hari, 10GB");
            prepaidData7Days30.setPrice(new BigDecimal("30000"));
            prepaidData7Days30.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData7Days30);

            Prepaid prepaidData30Days50 = new Prepaid();
            prepaidData30Days50.setPrepaidName("Internet OMG 50rb/30 hari");
            prepaidData30Days50.setPrepaidDetails("all network + bebas zona, 30 hari, 12GB");
            prepaidData30Days50.setPrice(new BigDecimal("50000"));
            prepaidData30Days50.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData30Days50);

            Prepaid prepaidData30Days75 = new Prepaid();
            prepaidData30Days75.setPrepaidName("Internet OMG 75rb/30 hari");
            prepaidData30Days75.setPrepaidDetails("all network + bebas zona, 30 hari, 18GB");
            prepaidData30Days75.setPrice(new BigDecimal("75000"));
            prepaidData30Days75.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData7Days30);

            Prepaid prepaidData30Days100 = new Prepaid();
            prepaidData30Days100.setPrepaidName("Internet OMG 100rb/30 hari");
            prepaidData30Days100.setPrepaidDetails("all network + bebas zona, 30 hari, 21GB");
            prepaidData30Days100.setPrice(new BigDecimal("100000"));
            prepaidData30Days100.setPrepaidType(PrepaidTypeEnum.MOBILE_PHONE_DATA);
            prepaidRepository.save(prepaidData30Days100);

            Prepaid prepaid20Electricity = new Prepaid();
            prepaid20Electricity.setPrepaidName("Token PLN 20.000");
            prepaid20Electricity.setPrice(new BigDecimal("22000"));
            prepaid20Electricity.setPrepaidType(PrepaidTypeEnum.ELECTRICITY_CREDIT);
            prepaidRepository.save(prepaid20Electricity);

            Prepaid prepaid50Electricity = new Prepaid();
            prepaid50Electricity.setPrepaidName("Token PLN 50.000");
            prepaid50Electricity.setPrice(new BigDecimal("52000"));
            prepaid50Electricity.setPrepaidType(PrepaidTypeEnum.ELECTRICITY_CREDIT);
            prepaidRepository.save(prepaid50Electricity);

            Prepaid prepaid100Electricity = new Prepaid();
            prepaid100Electricity.setPrepaidName("Token PLN 100.000");
            prepaid100Electricity.setPrice(new BigDecimal("102000"));
            prepaid100Electricity.setPrepaidType(PrepaidTypeEnum.ELECTRICITY_CREDIT);
            prepaidRepository.save(prepaid100Electricity);
        }
    }
}
