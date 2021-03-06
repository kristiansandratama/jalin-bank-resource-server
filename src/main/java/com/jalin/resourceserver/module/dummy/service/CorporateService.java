package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.dummy.model.CorporateDto;

import java.util.List;

public interface CorporateService {
    List<CorporateDto> getBankCorporates();
    List<CorporateDto> getDigitalWalletCorporates();
    List<CorporateDto> getMerchantCorporates();
    CorporateDto getCorporateById(String corporateId);
}
