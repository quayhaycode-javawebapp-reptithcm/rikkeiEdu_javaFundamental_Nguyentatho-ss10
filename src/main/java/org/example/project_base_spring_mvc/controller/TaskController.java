package org.example.project_base_spring_mvc.controller;

import jakarta.validation.Valid;
import org.example.project_base_spring_mvc.dto.TaskItem;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")

public class TaskController {

    private static List<TaskItem> tasks = new ArrayList<>();
    // Khởi tạo dữ liệu mẫu (Mock data)
    static {
        tasks.add(new TaskItem("T1", "Học Spring Boot cơ bản", LocalDate.now().plusDays(3), "HIGH"));
        tasks.add(new TaskItem("T2", "Làm bài tập Thymeleaf", LocalDate.now().plusDays(5), "MEDIUM"));
        tasks.add(new TaskItem("T3", "Ôn tập Java Core", LocalDate.now().plusDays(10), "LOW"));
    }


    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/add")
    public String createTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem,
                            BindingResult result
    ){
        if(result.hasErrors()){
            return "form-add";
        }
        tasks.add(taskItem);
        return "redirect:/tasks";
    }

    // giao dien form
    @GetMapping("/form-add")
    public String getFormAdd(Model model){
        model.addAttribute("taskItem", new TaskItem());
        return "form-add";
    }

}
