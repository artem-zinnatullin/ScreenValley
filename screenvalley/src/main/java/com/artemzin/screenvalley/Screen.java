package com.artemzin.screenvalley;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a screen of the app.
 * <p/>
 * Screen is build of {@link ScreenPart}s,
 * just like {@link android.app.Activity} and {@link android.app.Fragment}.
 */
public abstract class Screen {

    @NonNull
    private final ScreenValley screenValley;

    /**
     * Contains currently displayed {@link ScreenPart}s.
     */
    @NonNull
    private final Set<ScreenPart> screenParts = new HashSet<>(1);

    public Screen(@NonNull ScreenValley screenValley) {
        this.screenValley = screenValley;
    }

    public void addScreenPart(@IdRes int viewGroupId, @NonNull ScreenPart screenPart) {
        final boolean suchScreenPartAlreadyAdded = screenParts.add(screenPart);

        if (suchScreenPartAlreadyAdded) {
            throw new IllegalStateException("Exact same instance of screenPart was already added "
                    + "to this Screen. Screen class == " + getClass().getCanonicalName()
                    + "ScreenPart class == " + screenPart.getClass().getCanonicalName());
        }

        final ViewGroup container = ((ViewGroup) screenValley.activity().findViewById(viewGroupId));
        container.addView(screenPart.getView());
    }
}
