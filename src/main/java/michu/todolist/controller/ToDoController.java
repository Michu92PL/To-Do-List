package michu.todolist.controller;

import michu.todolist.model.Task;
import michu.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ToDoController {

    @Autowired
    TaskService taskService;

    @GetMapping("/add")
    public ModelAndView showAddView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTask");
        modelAndView.addObject("Task", new Task());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addTask(@Valid  @ModelAttribute("Task") Task task){
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView showTasks(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tasks");
        modelAndView.addObject("tasks", taskService.findAllActive());
        return modelAndView;
    }
}
