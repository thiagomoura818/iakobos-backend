package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.Testament;
import com.iakobos.iakobos.dto.TestamentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestamentMapper {

    TestamentDTO toResponse(Testament testament);
}
