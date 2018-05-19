/**
 * Copyright (C) 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.Param;
import org.kefirsf.todo.ToDoItem;
import org.kefirsf.todo.ToDoService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;


@Singleton
public class ApplicationController {
    private ToDoService toDoService;

    @Inject
    public ApplicationController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    public Result index() {
        return Results.text().render("Hello Ninja Todo!");
    }

    public Result create(@Param("text") String text) {
        long id = toDoService.create(text);
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return Results.json().render(map);
    }

    public Result get(@Param("id") long id) {
        ToDoItem item = toDoService.get(id);
        if (item != null) {
            return Results.json().render(item);
        } else {
            return Results.notFound();
        }
    }

    public Result update(@Param("id") long id, @Param("text") String text) {
        if (toDoService.update(id, text)) {
            return Results.ok();
        } else {
            return Results.notFound();
        }
    }

    public Result delete(@Param("id") long id) {
        if (toDoService.delete(id)) {
            return Results.ok();
        } else {
            return Results.notFound();
        }
    }

    public Result list() {
        return Results.json().render(toDoService.list());
    }
}
