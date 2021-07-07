package com.jalin.resourceserver.seeder;

import com.jalin.resourceserver.module.dummy.entity.Provider;
import com.jalin.resourceserver.module.dummy.repository.ProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Order(value = 2)
@Slf4j
public class ProviderSeeder implements CommandLineRunner {
    @Autowired
    private ProviderRepository providerRepository;

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
        if (providerRepository.count() == 0) {
            Provider providerSimpati = new Provider();
            providerSimpati.setProviderId("7001");
            providerSimpati.setPrefixNumber("0821");
            providerSimpati.setProductName("SIMPATI");
            providerSimpati.setProviderName("TELKOMSEL");
            providerRepository.save(providerSimpati);

            Provider providerXl = new Provider();
            providerXl.setProviderId("7002");
            providerXl.setPrefixNumber("0817");
            providerXl.setProductName("XL");
            providerXl.setProviderName("XL AXIATA");
            providerRepository.save(providerXl);
        }
    }
}
