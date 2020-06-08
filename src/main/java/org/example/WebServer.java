package org.example;

import static spark.Spark.get;

public class WebServer {
    public static void main(String[] args) {
        PigLatin pigLatin = new PigLatin();

        get("/translate", new GetTranslation(pigLatin));
    }
}
