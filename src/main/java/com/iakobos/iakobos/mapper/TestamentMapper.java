package com.iakobos.iakobos.mapper;

import com.iakobos.iakobos.model.Testament;
<<<<<<< HEAD
import com.iakobos.iakobos.dto.TestamentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TestamentMapper {

    TestamentDTO toResponse(Testament testament);
=======
import com.iakobos.iakobos.model.dto.Testament.TestamentResponse;

public class TestamentMapper {
    public static TestamentResponse toResponse(Testament testament){
        if(testament == null)
            return null;

        return new TestamentResponse(testament.getId(), testament.getName());
    }
>>>>>>> f0c0fea6772347fafa627a64ee3e1670ce5099d7
}
