package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.dummy.model.PrepaidDetailsDto;
import com.jalin.resourceserver.module.dummy.model.PrepaidDto;

import java.util.List;
import java.util.UUID;

public interface PrepaidService {
    List<PrepaidDto> getMobilePhoneCreditPrepaid();
    List<PrepaidDetailsDto> getMobilePhoneDataPrepaid();
    List<PrepaidDto> getElectricityPrepaid();
    PrepaidDto getMobilePhoneCreditPrepaidById(UUID prepaidId);
    PrepaidDetailsDto getMobilePhoneDataPrepaidById(UUID prepaidId);
    PrepaidDto getElectricityPrepaidById(UUID prepaidId);
}
