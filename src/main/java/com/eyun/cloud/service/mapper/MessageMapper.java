package com.eyun.cloud.service.mapper;

import com.eyun.cloud.domain.*;
import com.eyun.cloud.service.dto.MessageDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Message and its DTO MessageDTO.
 */
@Mapper(componentModel = "spring", uses = {SourceMapper.class})
public interface MessageMapper extends EntityMapper<MessageDTO, Message> {

    @Mapping(source = "sourcename.id", target = "sourcenameId")
    MessageDTO toDto(Message message); 

    @Mapping(source = "sourcenameId", target = "sourcename")
    Message toEntity(MessageDTO messageDTO);

    default Message fromId(Long id) {
        if (id == null) {
            return null;
        }
        Message message = new Message();
        message.setId(id);
        return message;
    }
}
