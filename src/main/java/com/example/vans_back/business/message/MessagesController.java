package com.example.vans_back.business.message;

import com.example.vans_back.business.message.dto.MessageDto;
import com.example.vans_back.domain.user.message.MessageRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Resource
    private MessagesService messagesService;

    @GetMapping("/view")
    @Operation(summary = "Toob kõik teated andmebaasist",
            description = "tagastab info userId kaudu")
    public List<MessageDto> findMessages(@RequestParam Integer userId) {
        List<MessageDto> messages = messagesService.findMessages(userId);
        return messages;
    }

    @PostMapping
    @Operation(summary = "Saadab uue teate",
            description = "lisab ajatempli saatmise hetkel ning omistab staatuse SENT")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        messagesService.sendMessage(messageRequest);
    }




}
