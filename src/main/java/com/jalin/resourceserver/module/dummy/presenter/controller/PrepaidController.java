package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.dummy.model.PrepaidDetailsDto;
import com.jalin.resourceserver.module.dummy.model.PrepaidDto;
import com.jalin.resourceserver.module.dummy.service.PrepaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class PrepaidController {
    @Autowired
    private PrepaidService prepaidService;

    @GetMapping("/prepaid/mobile/credit")
    public ResponseEntity<Object> getMobilePhoneCreditPrepaid() {
        List<PrepaidDto> prepaidDtoList = prepaidService.getMobilePhoneCreditPrepaid();
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Mobile phone credit prepaid successfully found", prepaidDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/prepaid/mobile/data")
    public ResponseEntity<Object> getMobilePhoneDataPrepaid() {
        List<PrepaidDetailsDto> prepaidDetailsDtoList = prepaidService.getMobilePhoneDataPrepaid();
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Mobile phone data prepaid successfully found", prepaidDetailsDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/prepaid/electricity")
    public ResponseEntity<Object> getElectricityPrepaid() {
        List<PrepaidDto> prepaidDtoList = prepaidService.getElectricityPrepaid();
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Electricity prepaid successfully found", prepaidDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/prepaid/mobile/credit/{prepaidId}")
    public ResponseEntity<Object> getMobilePhoneCreditPrepaidById(@PathVariable UUID prepaidId) {
        PrepaidDto prepaidDto = prepaidService.getMobilePhoneCreditPrepaidById(prepaidId);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Mobile phone credit prepaid successfully found", prepaidDto),
                HttpStatus.OK);
    }

    @GetMapping("/prepaid/mobile/data/{prepaidId}")
    public ResponseEntity<Object> getMobilePhoneDataPrepaidById(@PathVariable UUID prepaidId) {
        PrepaidDetailsDto prepaidDetailsDto = prepaidService.getMobilePhoneDataPrepaidById(prepaidId);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Mobile phone data prepaid successfully found", prepaidDetailsDto),
                HttpStatus.OK);
    }
}
