package com.amalitech.springboottodoapp.controller;

import com.amalitech.springboottodoapp.models.TaskModel;
import com.amalitech.springboottodoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping("/")
    public String index() {
        return "addTask";
    }
    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
return "addTask";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestBody TaskModel task) {
        // Process the task (e.g., save to database)
        taskService.addTask(task);

        // Redirect to the appropriate page after adding the task
        return "redirect:/addTask"; // Redirect to a success page or task list
    }
    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks"; // Redirect to the tasks page after deleting a task
    }
}