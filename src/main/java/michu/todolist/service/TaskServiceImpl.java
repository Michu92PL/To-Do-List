package michu.todolist.service;

import michu.todolist.model.Task;
import michu.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void saveChangedTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void changeStatus(Long id, boolean status) {
        Task task = taskRepository.findById(id).get();
        task.setActive(status);
    }

    @Override
    public void addTask(Task task) {
        task.setCreationDate(LocalDate.now());
        task.setActive(true);
        taskRepository.save(task);
    }

    @Override
    public void archiveTask(Long id) {
        Task task = taskRepository.findById(id).get();
        task.setActive(false);
        saveChangedTask(task);
    }

    @Override
    public void archiveTask(Task task) {
        task.setActive(false);

    }

    @Override
    public Collection<Task> findAllActive() {
        //return taskRepository.findAllByActiveTrue();
        ArrayList<Task> activeTasks = new ArrayList<>();

        for(Task task : taskRepository.findAll()){
            if(task.isActive()){
                activeTasks.add(task);
            }
        }
            return activeTasks;
    }

    @Override
    public Collection<Task> findAllArchived() {
        return taskRepository.findAll().stream().filter(t -> !t.isActive()).collect(Collectors.toList());

    }


    @Override
    public Collection<Task> findAllByDate(Date date) {
        return null;
    }

    @Override
    public Collection<Task> findAllByImportance(short imp) {
        return null;
    }
}
