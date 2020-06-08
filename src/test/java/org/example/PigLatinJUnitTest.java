package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PigLatinJUnitTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertEquals("appleway", actual);
        assertEquals("appleway", translator.translate("apple"));
    }
}
