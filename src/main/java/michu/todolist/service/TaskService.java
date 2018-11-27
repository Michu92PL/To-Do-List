package michu.todolist.service;

import michu.todolist.model.Task;

import java.util.Collection;

public interface TaskService {

    void addTask(Task task);
    void archiveTask(Task task);
    Collection<Task> findAllActive();
    Collection<Task> findAllArchived();
    Collection<Task> findAllByDate();
    Collection<Task> findAllByImportance(short imp);
}
