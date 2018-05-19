package org.kefirsf.jooby.todo;

import org.jooby.Result;
import org.jooby.Results;
import org.jooby.Status;
import org.jooby.mvc.*;
import org.kefirsf.todo.ToDoItem;
import org.kefirsf.todo.ToDoService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
@Path("/todo")
public class ToDoController {
    private ToDoService toDoService;

    @Inject
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @Path("/create")
    @POST
    public Result create(String text) {
        long id = toDoService.create(text);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return Results.json(map);
    }

    @Path("/get")
    @GET
    public Result get(long id) {
        ToDoItem item = toDoService.get(id);
        if (item != null) {
            return Results.json(item);
        } else {
            return Results.with(Status.NOT_FOUND);
        }
    }

    @Path("/update")
    @PUT
    public Result update(long id, String text) {
        if (toDoService.update(id, text)) {
            return Results.ok();
        } else {
            return Results.with(Status.NOT_FOUND);
        }
    }

    @Path("/delete")
    @DELETE
    public Result delete(long id) {
        if (toDoService.delete(id)) {
            return Results.ok();
        } else {
            return Results.with(Status.NOT_FOUND);
        }
    }

    @Path("/list")
    @GET
    public Result list() {
        return Results.json(toDoService.list());
    }
}
