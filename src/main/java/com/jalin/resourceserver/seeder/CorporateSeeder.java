package com.jalin.resourceserver.seeder;

import com.jalin.resourceserver.module.dummy.entity.Corporate;
import com.jalin.resourceserver.module.dummy.entity.CorporateTypeEnum;
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
            Corporate corporateJalin = new Corporate();
            corporateJalin.setCorporateId("212");
            corporateJalin.setCorporateName("Bank Jalin");
            corporateJalin.setCorporateType(CorporateTypeEnum.BANK);
            corporateRepository.save(corporateJalin);

            Corporate corporateBri = new Corporate();
            corporateBri.setCorporateId("002");
            corporateBri.setCorporateName("Bank BRI");
            corporateBri.setCorporateType(CorporateTypeEnum.BANK);
            corporateRepository.save(corporateBri);

            Corporate corporateMandiri = new Corporate();
            corporateMandiri.setCorporateId("008");
            corporateMandiri.setCorporateName("Bank Mandiri");
            corporateMandiri.setCorporateType(CorporateTypeEnum.BANK);
            corporateRepository.save(corporateMandiri);

            Corporate corporateBni = new Corporate();
            corporateBni.setCorporateId("009");
            corporateBni.setCorporateName("Bank BNI");
            corporateBni.setCorporateType(CorporateTypeEnum.BANK);
            corporateRepository.save(corporateBni);

            Corporate corporateGopay = new Corporate();
            corporateGopay.setCorporateId("9101");
            corporateGopay.setCorporateName("Gopay");
            corporateGopay.setCorporateType(CorporateTypeEnum.DIGITAL_WALLET);
            corporateRepository.save(corporateGopay);

            Corporate corporateOvo = new Corporate();
            corporateOvo.setCorporateId("9102");
            corporateOvo.setCorporateName("OVO");
            corporateOvo.setCorporateType(CorporateTypeEnum.DIGITAL_WALLET);
            corporateRepository.save(corporateOvo);

            Corporate corporateDana = new Corporate();
            corporateDana.setCorporateId("9103");
            corporateDana.setCorporateName("Dana");
            corporateDana.setCorporateType(CorporateTypeEnum.DIGITAL_WALLET);
            corporateRepository.save(corporateDana);

            Corporate corporateShopeepay = new Corporate();
            corporateShopeepay.setCorporateId("9104");
            corporateShopeepay.setCorporateName("Shopeepay");
            corporateShopeepay.setCorporateType(CorporateTypeEnum.DIGITAL_WALLET);
            corporateRepository.save(corporateShopeepay);

            Corporate corporateLinkAja = new Corporate();
            corporateLinkAja.setCorporateId("9105");
            corporateLinkAja.setCorporateName("LinkAja");
            corporateLinkAja.setCorporateType(CorporateTypeEnum.DIGITAL_WALLET);
            corporateRepository.save(corporateLinkAja);

            Corporate corporateYoshinoya = new Corporate();
            corporateYoshinoya.setCorporateId("5001001001");
            corporateYoshinoya.setCorporateName("Yoshinoya Pondok Indah Mall 1");
            corporateYoshinoya.setCorporateType(CorporateTypeEnum.MERCHANT);
            corporateRepository.save(corporateYoshinoya);

            Corporate corporateSushiTei = new Corporate();
            corporateSushiTei.setCorporateId("5002001001");
            corporateSushiTei.setCorporateName("Sushi Tei Grand Indonesia");
            corporateSushiTei.setCorporateType(CorporateTypeEnum.MERCHANT);
            corporateRepository.save(corporateSushiTei);
        }
    }
}
