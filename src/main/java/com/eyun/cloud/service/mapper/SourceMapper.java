package com.eyun.cloud.service.mapper;

import com.eyun.cloud.domain.*;
import com.eyun.cloud.service.dto.SourceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Source and its DTO SourceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface SourceMapper extends EntityMapper<SourceDTO, Source> {

    

    

    default Source fromId(Long id) {
        if (id == null) {
            return null;
        }
        Source source = new Source();
        source.setId(id);
        return source;
    }
}
