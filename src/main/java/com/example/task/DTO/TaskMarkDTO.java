package com.example.task.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TaskMarkDTO {
    private Long userId;
    private Integer mark;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
