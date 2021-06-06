package com.jalin.resourceserver.utility;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtility {
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
