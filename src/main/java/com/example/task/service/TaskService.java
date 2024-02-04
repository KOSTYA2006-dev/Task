package com.example.task.service;

import com.example.task.DTO.TaskDTO;
import com.example.task.model.Task;
import com.example.task.model.User;
import com.example.task.repo.TaskRepository;
import com.example.task.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Не найдено!"));
        return convertToDto(task);
    }

    public void createTask(TaskDTO taskDTO) {
        Task task = convertToEntity(taskDTO);
        taskRepository.save(task);
    }

    public void updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Нету такого таска"));
        Task updatedTask = convertToEntity(taskDTO);
        updatedTask.setId(existingTask.getId());
        taskRepository.save(updatedTask);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Не найдено!"));
        taskRepository.delete(task);
    }

    public void Noaccept(Long taskId){
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setUser_name(null);
            task.setStatus(true);
            taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found with id: " + taskId);
        }

    }

    public void accept(Long taskId, String userId){
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setUser_name(userId);
            task.setStatus(false);
            taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found with id: " + taskId);
        }



    }
    public void mark(Long taskId, String userId){
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        Optional<User> optionalUser = userRepository.findById(Long.valueOf(userId));
        if (optionalTask.isPresent()) {
            User user = optionalUser.get();
            Task task = optionalTask.get();
            user.setMark(task.getMark());
            task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Не найдено!"));
            taskRepository.delete(task);

        } else {
            throw new RuntimeException("Task not found with id: " + taskId);
        }



    }


    private TaskDTO convertToDto(Task task) {

        return new TaskDTO(task.getId(), task.getNames(), task.getDescription(), task.getPriority(), task.getMark(), task.getStatus(), task.getUser_name(), task.getCreationTime());
    }

    private Task convertToEntity(TaskDTO taskDTO) {

        return new Task(taskDTO.getName(), taskDTO.getDescription(), taskDTO.getPriority(), taskDTO.getMark(), taskDTO.getUser_name(), taskDTO.getCreationTime());
    }
}