package org.kefirsf.spark.todo;

import com.google.gson.Gson;
import com.google.inject.Inject;
import org.kefirsf.todo.ToDoItem;
import org.kefirsf.todo.ToDoService;
import spark.Request;
import spark.Response;

import java.text.MessageFormat;

public class ToDoController {
    private ToDoService toDoService;
    private Gson gson;

    @Inject
    public ToDoController(ToDoService toDoService, Gson gson) {
        this.toDoService = toDoService;
        this.gson = gson;
    }

    Object create(Request request, Response response) {
        long id = toDoService.create(request.params("text"));
        response.type("application/json");
        return MessageFormat.format("'{'\"id\":{0}'}'", id);
    }

    Object get(Request request, Response response) {
        ToDoItem item = toDoService.get(Long.valueOf(request.params("id")));
        if (item != null) {
            response.type("application/json");
            return gson.toJson(item);
        } else {
            response.status(404);
            return null;
        }
    }

    Object update(Request request, Response response) {
        if (toDoService.update(Long.valueOf(request.params("id")), request.params("text"))) {
            return null;
        } else {
            response.status(404);
            return null;
        }
    }

    Object delete(Request request, Response response) {
        if (toDoService.delete(Long.valueOf(request.params("id")))) {
            return null;
        } else {
            response.status(404);
            return null;
        }
    }

    Object list(Request request, Response response) {
        response.type("application/json");
        return gson.toJson(toDoService.list());
    }
}
