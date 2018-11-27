package michu.todolist.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Temporal(TemporalType.DATE)
    private Date untilWhen;
    private String description;
    private short importance;
    private boolean isActive;

    public Task() {
    }

    public Task(Date untilWhen, String description, short importance) {
        this.untilWhen = untilWhen;
        this.description = description;
        this.importance = importance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUntilWhen() {
        return untilWhen;
    }

    public void setUntilWhen(Date untilWhen) {
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
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
