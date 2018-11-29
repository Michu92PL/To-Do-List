package michu.todolist.repository;

import michu.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Collection<Task> findAllByActiveTrue();
}
