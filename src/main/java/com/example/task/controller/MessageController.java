package com.example.task.controller;

import com.example.task.DTO.MessageDTO;
import com.example.task.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages/create")
    public String showCreateMessageForm() {

        return "create_message";
    }

    @PostMapping("/messages/create")
    public String createMessage(@ModelAttribute("messageDTO") MessageDTO messageDTO) {
        messageService.createMessage(messageDTO);
        return "redirect:/messages";
    }

    // Другие методы для получения, обновления и удаления сообщений
}

