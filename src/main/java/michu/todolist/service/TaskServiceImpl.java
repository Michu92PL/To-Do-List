package michu.todolist.service;

import michu.todolist.model.Task;
import michu.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void addTask(Task task) {
        task.setCreationDate(new Date());
        task.setActive(true);
        taskRepository.save(task);
    }

    @Override
    public void archiveTask(Task task) {
        task.setActive(false);

    }

    @Override
    public Collection<Task> findAllActive() {
        return taskRepository.findAll().stream().filter(t -> t.isActive()).collect(Collectors.toList());
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
