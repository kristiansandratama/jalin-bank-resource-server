package com.jalin.resourceserver.seeder;

import com.jalin.resourceserver.module.dummy.entity.Corporate;
import com.jalin.resourceserver.module.dummy.repository.CorporateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Order(value = 1)
@Slf4j
public class CorporateSeeder implements CommandLineRunner {
    @Autowired
    private CorporateRepository corporateRepository;

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
        if (corporateRepository.count() == 0) {
            Corporate corporateGopay = new Corporate();
            corporateGopay.setCorporateId("9101");
            corporateGopay.setCorporateName("Gopay");
            corporateRepository.save(corporateGopay);

            Corporate corporateOvo = new Corporate();
            corporateOvo.setCorporateId("9102");
            corporateOvo.setCorporateName("OVO");
            corporateRepository.save(corporateOvo);

            Corporate corporateDana = new Corporate();
            corporateDana.setCorporateId("9103");
            corporateDana.setCorporateName("Dana");
            corporateRepository.save(corporateDana);

            Corporate corporateShopeepay = new Corporate();
            corporateShopeepay.setCorporateId("9103");
            corporateShopeepay.setCorporateName("Shopeepay");
            corporateRepository.save(corporateShopeepay);

            Corporate corporateLinkAja = new Corporate();
            corporateLinkAja.setCorporateId("9104");
            corporateLinkAja.setCorporateName("LinkAja");
            corporateRepository.save(corporateLinkAja);
        }
    }
}
