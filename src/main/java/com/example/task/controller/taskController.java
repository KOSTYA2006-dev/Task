package com.example.task.controller;

import com.example.task.DTO.TaskDTO;
import com.example.task.repo.TaskRepository;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public String getAllTasks(Model model) {
        List<TaskDTO> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task";
    }

    @GetMapping("/{id}")
    public String getTaskById(@PathVariable Long id, Model model) {
        TaskDTO task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("/admin")
    public String newTask(Model model){
        return "admin";

    }

    @PostMapping("/accept/{id}")
    public String toAccept(@PathVariable Long id){
        System.out.println("dsad");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = String.valueOf(authentication.getName());

        taskService.accept(id, userId);

        return "redirect:/task";

    }

    @PostMapping("/noaccept/{id}")
    public String NotoAccept(@PathVariable Long id){
        System.out.println("dsad");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = String.valueOf(authentication.getName());

        taskService.Noaccept(id);

        return "redirect:/task";

    }


    }


