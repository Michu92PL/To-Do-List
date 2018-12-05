package michu.todolist.service;

import michu.todolist.model.Task;

import java.util.Collection;
import java.util.Date;

public interface TaskService {


    void saveChangedTask(Task task);
    void changeStatus(Long id, boolean status);
    void addTask(Task task);
    void archiveTask(Long id);
    void archiveTask(Task task);
    Collection<Task> findAllActive();
    Collection<Task> findAllArchived();
    Collection<Task> findAllByDate(Date date);
    Collection<Task> findAllByImportance(short imp);
}
