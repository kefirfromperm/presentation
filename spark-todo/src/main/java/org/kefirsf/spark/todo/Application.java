package org.kefirsf.spark.todo;

import com.google.inject.Guice;
import com.google.inject.Injector;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        ToDoController controller = injector.getInstance(ToDoController.class);

        get("/hello", (req, res) -> "Hello Spark Todo!");
        path("/todo",() -> {
            post("/create", controller::create);
            get("/get", controller::get);
            put("/update", controller::update);
            delete("/delete", controller::delete);
            get("/list", controller::list);
        });
    }
}
