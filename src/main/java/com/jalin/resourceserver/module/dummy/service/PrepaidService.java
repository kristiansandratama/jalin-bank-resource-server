package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.dummy.model.PrepaidDto;

import java.util.List;
import java.util.UUID;

public interface PrepaidService {
    List<PrepaidDto> getMobilePhoneCreditPrepaid();
    PrepaidDto getMobilePhoneCreditPrepaidById(UUID prepaidId);
}
