package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PigLatinHamcrestTest {
    @Test
    void itConvertsEnglishToPigLatin() {
        PigLatin translator = new PigLatin();

        String actual = translator.translate("apple");

        assertThat("appleway", equalTo(actual));

        // Or
        assertThat("appleway", equalTo(translator.translate("apple")));

        // Or
        assertThat("appleway", is(equalTo(actual)));

        // Or
        assertThat("appleway", is(equalTo(translator.translate("apple"))));
    }
}
