package com.jalin.resourceserver.utility;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtility {
    public ModelMapper initialize() {
        return new ModelMapper();
    }
}
