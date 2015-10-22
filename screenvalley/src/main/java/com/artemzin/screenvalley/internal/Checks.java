package com.artemzin.screenvalley.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Bunch of check methods
 * <p>
 * For internal usage only!
 */
public final class Checks {

    private Checks() {
        throw new IllegalStateException("No instances please.");
    }

    /**
     * Checks that passed reference is not null,
     * throws {@link NullPointerException} with passed message if reference is null
     *
     * @param object  to check
     * @param message exception message if object is null
     */
    public static void checkNotNull(@Nullable Object object, @NonNull String message) {
        if (object == null) {
            throw new NullPointerException(message);
        }
    }
}