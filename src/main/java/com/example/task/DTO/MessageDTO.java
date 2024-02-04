package com.example.task.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {

    private String Names;
    private String message;

    private Long id_task;
    private Long id_user;

    public MessageDTO(String Names, String message, Long id_task, Long id_user) {
        this.Names = Names;
        this.message = message;
        this.id_task = id_task;
        this.id_user = id_user;
    }
}
