package org.kefirsf.todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ToDoService {
    private AtomicLong sequence = new AtomicLong();
    private Map<Long, ToDoItem> map = new ConcurrentHashMap<>();

    public long create(String text) {
        long id = sequence.incrementAndGet();
        map.put(id, new ToDoItem(id, text));
        return id;
    }

    public ToDoItem get(long id) {
        return map.get(id);
    }

    public boolean update(long id, String text) {
        ToDoItem item = map.get(id);
        if (item != null) {
            item.setText(text);
            item.setDate(LocalDateTime.now());
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(long id) {
        return map.remove(id) != null;
    }

    public List<ToDoItem> list() {
        return new ArrayList<>(map.values());
    }
}
