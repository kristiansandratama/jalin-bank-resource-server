package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.module.dummy.model.ProviderDto;

import java.util.List;

public interface ProviderService {
    List<ProviderDto> getProviders();
    ProviderDto getProviderByPrefixNumber(String prefixNumber);
    ProviderDto getProviderByProviderId(String providerId);
}
