package com.jalin.resourceserver.module.dummy.service;

import com.jalin.resourceserver.exception.ResourceNotFoundException;
import com.jalin.resourceserver.module.dummy.entity.Provider;
import com.jalin.resourceserver.module.dummy.model.ProviderDto;
import com.jalin.resourceserver.module.dummy.repository.ProviderRepository;
import com.jalin.resourceserver.utility.ModelMapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ModelMapperUtility modelMapperUtility;
    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public List<ProviderDto> getProviders() {
        List<Provider> providerList = providerRepository.findAll();
        List<ProviderDto> providerDtoList = new ArrayList<>();
        for (Provider provider : providerList) {
            ProviderDto providerDto = modelMapperUtility.initialize()
                    .map(provider, ProviderDto.class);
            providerDtoList.add(providerDto);
        }
        return providerDtoList;
    }

    @Override
    public ProviderDto getProviderByPrefixNumber(String prefixNumber) {
        Provider provider = providerRepository.findByPrefixNumber(prefixNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Provider with prefix number %s not found", prefixNumber)));
        return modelMapperUtility.initialize().map(provider, ProviderDto.class);
    }

    @Override
    public ProviderDto getProviderByProviderId(String providerId) {
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Provider with ID %s not found", providerId)));

        return modelMapperUtility.initialize().map(provider, ProviderDto.class);
    }
}
