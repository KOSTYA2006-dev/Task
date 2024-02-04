package com.example.task.service;

import com.example.task.DTO.MessageDTO;
import com.example.task.model.Message;
import com.example.task.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Сообщение не найдено"));
    }

    public Message createMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setNames(messageDTO.getNames());
        message.setMessage(messageDTO.getMessage());
        message.setId_task(messageDTO.getId_task());
        message.setId_user(messageDTO.getId_user());
        return messageRepository.save(message);
    }
}

