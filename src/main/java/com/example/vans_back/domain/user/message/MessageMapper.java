package com.example.vans_back.domain.user.message;

import com.example.vans_back.business.message.dto.MessageDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {


    @Mapping(source = "id", target = "messageId")
    @Mapping(source = "dateTime", target = "messageDateTime")
    @Mapping(source = "status", target = "messageStatus")
    @Mapping(source = "text", target = "messageText")
    @Mapping(source = "receiverUser.username", target = "receiverUsername")
    @Mapping(source = "senderUser.username", target = "senderUsername")
    MessageDto toMessageDto(Message message);

    List<MessageDto> toMessageDtos(List<Message> messages);
}