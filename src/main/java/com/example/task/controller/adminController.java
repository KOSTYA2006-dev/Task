package com.example.task.controller;

import com.example.task.DTO.TaskDTO;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class adminController {

    @Autowired
    private TaskService taskService;

    @GetMapping("task/enter")
    public String modelTask(){

        return "new-task";
    }

    @GetMapping("/task/up/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        TaskDTO taskDTO = taskService.getTaskById(id);
        model.addAttribute("taskId", id);

        model.addAttribute("taskDTO", taskDTO);
        return "update";
    }


    @PostMapping("/task/mark/{id}")
    public String NotoAccept(@PathVariable Long id, @PathVariable String user_name){
        System.out.println("dsad");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = String.valueOf(user_name);

        taskService.mark(id, userId);

        return "redirect:/task";

    }
    @PostMapping("/task/new")
    public String createTask(@ModelAttribute("task") TaskDTO taskDTO) {
        taskService.createTask(taskDTO);
        System.out.println("ok");
        return "redirect:/admin";
    }

    @GetMapping("/task/all")
    public String getAllTasks(Model model) {
        List<TaskDTO> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "all-task";
    }

    @PostMapping("/task/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute TaskDTO taskDTO) {
        taskService.updateTask(id, taskDTO);
        return "redirect:/task";
    }

    @PostMapping("task/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/task/all";
    }

}
