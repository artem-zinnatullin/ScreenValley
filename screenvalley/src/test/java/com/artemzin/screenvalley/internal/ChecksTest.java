package com.artemzin.screenvalley.internal;

import org.junit.Test;

import static com.artemzin.screenvalley.internal.Checks.checkNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class ChecksTest {

    @Test
    public void checkNotNullPositive() {
        checkNotNull(new Object(), "No exceptions please");
    }

    @Test
    public void checkNotNullNegative() {
        try {
            checkNotNull(null, "Throw me!");
            failBecauseExceptionWasNotThrown(NullPointerException.class);
        } catch (NullPointerException expected) {
            assertThat(expected).hasMessage("Throw me!");
        }
    }
}