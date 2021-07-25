package com.jalin.resourceserver.module.dummy.presenter.controller;

import com.jalin.resourceserver.model.SuccessDetailsResponse;
import com.jalin.resourceserver.module.dummy.model.ProviderDto;
import com.jalin.resourceserver.module.dummy.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${url.map.api}/v1")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/providers")
    public ResponseEntity<Object> getProviders() {
        return new ResponseEntity<>(
                new SuccessDetailsResponse(
                        true,
                        "Provider successfully found",
                        providerService.getProviders()),
                HttpStatus.OK);
    }

    @GetMapping("/providers/{providerId}")
    public ResponseEntity<Object> getProviderById(@PathVariable String providerId) {
        ProviderDto providerDto = providerService.getProviderByProviderId(providerId);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Provider successfully found", providerDto),
                HttpStatus.OK);
    }

    @GetMapping("/providers/find")
    public ResponseEntity<Object> getProviderByPrefixNumber(@RequestParam String prefixNumber) {
        ProviderDto providerDto = providerService.getProviderByPrefixNumber(prefixNumber);
        return new ResponseEntity<>(
                new SuccessDetailsResponse(true, "Provider successfully found", providerDto),
                HttpStatus.OK);
    }
}
