package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.dummy.entity.Corporate;
import com.jalin.resourceserver.module.dummy.entity.CorporateTypeEnum;
import com.jalin.resourceserver.module.dummy.model.CorporateDto;
import com.jalin.resourceserver.module.dummy.repository.CorporateRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CorporateServiceImpl implements CorporateService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private CorporateRepository corporateRepository;

    @Override
    public List<CorporateDto> getBankCorporates() {
        List<Corporate> corporateList = corporateRepository.findByCorporateTypeOrderByCorporateNameAsc(CorporateTypeEnum.BANK);
        List<CorporateDto> corporateDtoList = new ArrayList<>();
        for (Corporate corporate : corporateList) {
            CorporateDto corporateDto = modelMapperUtility.initialize()
                    .map(corporate, CorporateDto.class);
            corporateDtoList.add(corporateDto);
        }
        return corporateDtoList;
    }

    @Override
    public List<CorporateDto> getDigitalWalletCorporates() {
        List<Corporate> corporateList = corporateRepository.findByCorporateTypeOrderByCorporateNameAsc(CorporateTypeEnum.DIGITAL_WALLET);
        List<CorporateDto> corporateDtoList = new ArrayList<>();
        for (Corporate corporate : corporateList) {
            CorporateDto corporateDto = modelMapperUtility.initialize()
                    .map(corporate, CorporateDto.class);
            corporateDtoList.add(corporateDto);
        }
        return corporateDtoList;
    }
}
