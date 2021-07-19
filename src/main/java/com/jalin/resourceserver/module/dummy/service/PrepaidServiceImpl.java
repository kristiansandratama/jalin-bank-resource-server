package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.dummy.entity.Prepaid;
import com.jalin.resourceserver.module.dummy.entity.PrepaidTypeEnum;
import com.jalin.resourceserver.module.dummy.model.PrepaidDetailsDto;
import com.jalin.resourceserver.module.dummy.model.PrepaidDto;
import com.jalin.resourceserver.module.dummy.repository.PrepaidRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PrepaidServiceImpl implements PrepaidService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private PrepaidRepository prepaidRepository;

    @Override
    public List<PrepaidDto> getMobilePhoneCreditPrepaid() {
        List<Prepaid> prepaidList = prepaidRepository.findByPrepaidTypeOrderByPriceAsc(PrepaidTypeEnum.MOBILE_PHONE_CREDIT);
        List<PrepaidDto> prepaidDtoList = new ArrayList<>();
        for (Prepaid prepaid : prepaidList) {
            PrepaidDto prepaidDto = modelMapperUtility.initialize()
                    .map(prepaid, PrepaidDto.class);
            prepaidDtoList.add(prepaidDto);
        }
        return prepaidDtoList;
    }

    @Override
    public List<PrepaidDetailsDto> getMobilePhoneDataPrepaid() {
        List<Prepaid> prepaidList = prepaidRepository.findByPrepaidTypeOrderByPriceAsc(PrepaidTypeEnum.MOBILE_PHONE_DATA);
        List<PrepaidDetailsDto> prepaidDetailsDtoList = new ArrayList<>();
        for (Prepaid prepaid : prepaidList) {
            PrepaidDetailsDto prepaidDetailsDto = modelMapperUtility.initialize()
                    .map(prepaid, PrepaidDetailsDto.class);
            prepaidDetailsDtoList.add(prepaidDetailsDto);
        }
        return prepaidDetailsDtoList;
    }

    @Override
    public List<PrepaidDto> getElectricityPrepaid() {
        List<Prepaid> prepaidList = prepaidRepository.findByPrepaidTypeOrderByPriceAsc(PrepaidTypeEnum.ELECTRICITY_CREDIT);
        List<PrepaidDto> prepaidDtoList = new ArrayList<>();
        for (Prepaid prepaid : prepaidList) {
            PrepaidDto prepaidDto = modelMapperUtility.initialize()
                    .map(prepaid, PrepaidDto.class);
            prepaidDtoList.add(prepaidDto);
        }
        return prepaidDtoList;
    }

    @Override
    public PrepaidDto getMobilePhoneCreditPrepaidById(UUID prepaidId) {
        Prepaid prepaid = prepaidRepository.findById(prepaidId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Mobile phone credit prepaid with ID %s not found", prepaidId)));

        return modelMapperUtility.initialize().map(prepaid, PrepaidDto.class);
    }

    @Override
    public PrepaidDetailsDto getMobilePhoneDataPrepaidById(UUID prepaidId) {
        Prepaid prepaid = prepaidRepository.findById(prepaidId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Mobile phone data prepaid with ID %s not found", prepaidId)));

        return modelMapperUtility.initialize().map(prepaid, PrepaidDetailsDto.class);
    }

    @Override
    public PrepaidDto getElectricityPrepaidById(UUID prepaidId) {
        Prepaid prepaid = prepaidRepository.findById(prepaidId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Electricity prepaid with ID %s not found", prepaidId)));

        return modelMapperUtility.initialize().map(prepaid, PrepaidDto.class);
    }
}
