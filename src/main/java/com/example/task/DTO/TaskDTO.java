package com.example.task.DTO;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskDTO {

    private Long id;
    private String name;
    private String description;
    private String priority;
    private Integer mark;
    private Boolean status;
    private String user_name;
    private LocalDateTime creationTime;

    public TaskDTO(Long id, String name, String description, String priority, Integer mark, Boolean status, String user_name, LocalDateTime creationTime) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.mark = mark;
        this.status = status;
        this.user_name = user_name;
        this.creationTime = creationTime;

    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

}