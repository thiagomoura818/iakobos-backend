package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.Testament;
import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;

public class TestamentMapper {
    public static TestamentResponse toResponse(Testament testament){
        if(testament == null)
            return null;

        return new TestamentResponse(testament.getId(), testament.getName());
    }
}
