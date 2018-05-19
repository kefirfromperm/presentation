package org.kefirsf.jooby.todo;

import org.jooby.Jooby;

public class Application extends Jooby {
    {
        get("/", () -> "Hello Jooby ToDo!");
        use(ToDoController.class);
    }

    public static void main(final String[] args) {
        run(Application::new, args);
    }
}
