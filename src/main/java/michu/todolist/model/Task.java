package michu.todolist.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // @Temporal(TemporalType.DATE)
    private LocalDate creationDate;
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate untilWhen;
    private String description;
    private short importance;
    private boolean active;

    public Task() {
    }

    public Task(LocalDate untilWhen, String description, short importance) {
        this.untilWhen = untilWhen;
        this.description = description;
        this.importance = importance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUntilWhen() {
        return untilWhen;
    }

    public void setUntilWhen(LocalDate untilWhen) {
        this.untilWhen = untilWhen;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public short getImportance() {
        return importance;
    }

    public void setImportance(short importance) {
        this.importance = importance;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
