package org.example;

import spark.Request;
import spark.Response;
import spark.Route;

public class GetTranslation implements Route {
    private final PigLatin pigLatin;

    public GetTranslation(PigLatin pigLatin) {
        this.pigLatin = pigLatin;
    }

    @Override
    public Object handle(Request request, Response response) {
        String english = request.queryParams("english");

        return pigLatin.translate(english);
    }
}
