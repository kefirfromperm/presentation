package org.kefirsf.jooby;

import org.jooby.Jooby;

public class Application extends Jooby {
    {
        get("/", () -> "Hello Jooby!");
    }

    public static void main(final String[] args) {
        run(Application::new, args);
    }
}
