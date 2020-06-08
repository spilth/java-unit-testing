package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import spark.Request;
import spark.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class GetTranslationTest {
    private GetTranslation getTranslation;

    @Mock
    PigLatin pigLatin;

    @Mock
    private Request request;

    @Mock
    private Response response;

    @BeforeEach
    void setup() {
        initMocks(this);

        getTranslation = new GetTranslation(pigLatin);
    }

    @Test
    void handle() {
        when(request.queryParams("english")).thenReturn("apple");
        when(pigLatin.translate("apple")).thenReturn("appleway");

        Object result = getTranslation.handle(request, response);

        assertThat(result).isInstanceOfAny(String.class);
        assertThat(result).isEqualTo("appleway");
    }
}
