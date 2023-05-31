package com.example.vans_back.business.message;

import com.example.vans_back.business.message.dto.MessageDto;
import com.example.vans_back.domain.user.message.Message;
import com.example.vans_back.domain.user.message.MessageMapper;
import com.example.vans_back.domain.user.message.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagesService {

    @Resource
    private MessageService messageService;

    @Resource
    private MessageMapper messageMapper;

    public List<MessageDto> findMessages(Integer userId) {
        List<Message> messages = messageService.findAllMessagesBy(userId);
        List<MessageDto> messageDtos = messageMapper.toMessageDtos(messages);
        return messageDtos;
    }
}
