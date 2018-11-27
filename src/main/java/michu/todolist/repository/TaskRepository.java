package michu.todolist.repository;

import michu.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Collection<Task> findAllActive();
    Collection<Task> findAllArchived();
    Collection<Task> findAllByDate();
    Collection<Task> findAllByImportance(short imp);
}