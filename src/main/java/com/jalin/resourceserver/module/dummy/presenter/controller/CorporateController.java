package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.dummy.model.CorporateDto;
import com.jalin.resourceserver.module.dummy.service.CorporateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CorporateController {
    @Autowired
    private CorporateService corporateService;

    @GetMapping("/corporates/bank")
    public ResponseEntity<Object> getBankCorporates() {
        List<CorporateDto> corporateDtoList = corporateService.getBankCorporates();
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Bank corporates successfully found", corporateDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/corporates/wallet")
    public ResponseEntity<Object> getDigitalWalletCorporates() {
        List<CorporateDto> corporateDtoList = corporateService.getDigitalWalletCorporates();
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Digital wallet corporates successfully found", corporateDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/corporates/{corporateId}")
    public ResponseEntity<Object> getCorporateById(@PathVariable String corporateId) {
        CorporateDto corporateDto = corporateService.getCorporateById(corporateId);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Corporate successfully found", corporateDto),
                HttpStatus.OK);
    }
}
