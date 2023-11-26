package com.CL3RamirezAquinoClever.ExamenCL3.util;

import com.CL3RamirezAquinoClever.ExamenCL3.model.dto.DtoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class DtoUtil {

    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertirAEntidad(Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper, obj.getClass());
    }

}