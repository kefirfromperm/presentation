package org.kefirsf.spark;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello Spark!");
    }
}
