package com.artemzin.screenvalley;

import android.app.Activity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;
import static org.mockito.Mockito.mock;

public class ScreenValleyTest {

    @Test
    public void builderShouldThrowIfActivityNull() {
        ScreenValley.Builder0 builder = ScreenValley.builder();

        try {
            builder.activity(null);
            failBecauseExceptionWasNotThrown(NullPointerException.class);
        } catch (NullPointerException expected) {
            assertThat(expected).hasMessage("Activity must not be null");
        }
    }

    @Test
    public void builderShouldAllowNullPreviousState() {
        // No exceptions expected
        ScreenValley
                .builder()
                .activity(mock(Activity.class))
                .previousState(null)
                .build();
    }

    @Test
    public void builderShouldPassExactSameActivity() {
        Activity activity = mock(Activity.class);

        ScreenValley screenValley = ScreenValley
                .builder()
                .activity(activity)
                .previousState(null)
                .build();

        assertThat(screenValley.activity()).isSameAs(activity);
    }
}