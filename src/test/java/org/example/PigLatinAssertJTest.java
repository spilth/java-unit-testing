package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PigLatinAssertJTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertThat(actual).isEqualTo("appleway");

        // Or
        assertThat(translator.translate("apple")).isEqualTo("appleway");
    }
}
