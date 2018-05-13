package org.kefirsf.todo;

import java.time.LocalDateTime;
import java.util.Objects;

public class ToDoItem {
    private long id;
    private String text;
    private LocalDateTime date;

    public ToDoItem(long id, String text) {
        this.id = id;
        this.text = text;
        date = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return id == toDoItem.id &&
                Objects.equals(text, toDoItem.text) &&
                Objects.equals(date, toDoItem.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, date);
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
