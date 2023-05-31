package com.example.vans_back.business.message;

import com.example.vans_back.business.message.dto.MessageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessagesController {

    @Resource
    private MessagesService messagesService;

    @GetMapping("/view")
    @Operation(summary = "Toob kõik teated andmebaasist",
            description = "tagastab info saatja, saaja, staatuse ja ajatempliga")
    public List<MessageDto> findMessages(@RequestParam Integer userId) {
        List<MessageDto> messages = messagesService.findMessages(userId);
        return messages;
    }

}
