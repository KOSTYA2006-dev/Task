package com.example.task.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Names;

    private String Description;

    private String priority;

    private Integer mark;

    private Boolean status = true;

    private String user_name = null;

    private LocalDateTime creationTime;


    public Task(String names, String description, String priority, Integer mark, String user_name, LocalDateTime creationTime) {
        this.Names = names;
        this.Description = description;
        this.priority = priority;
        this.mark = mark;
        this.user_name = user_name;
        this.creationTime = creationTime;
    }


}
