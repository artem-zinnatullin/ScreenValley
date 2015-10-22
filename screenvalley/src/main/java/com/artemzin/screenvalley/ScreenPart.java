package com.artemzin.screenvalley;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Represents a part of {@link Screen}.
 * <p>
 * {@link Screen} may contain only one {@link ScreenPart} that takes all of the space.
 * <p>
 * {@link ScreenPart} is analogue of {@link android.app.Fragment}, but has much more lightweight
 * lifecycle and more simplified in general.
 */
public abstract class ScreenPart {

    /**
     * View of this {@link ScreenPart} created in {@link #createView()}.
     *
     * @see #createView()
     * @see #getView()
     */
    @NonNull
    private final View view;

    /**
     * Creates new {@link ScreenPart}.
     *
     * @param previousState optional (nullable) {@link Bundle} with previous state of the {@link ScreenPart}.
     */
    public ScreenPart(@Nullable Bundle previousState) {
        this.view = createView();
    }

    /**
     * Creates a {@link View} of this {@link ScreenPart}.
     * <p>
     * Called in the {@link ScreenPart}'s constructor since
     * {@link ScreenPart} can not live without view.
     * <p>
     * Contract of this method:
     * it should be called in the constructor of the {@link ScreenPart} and it should be called once.
     *
     * @return non-null view of this {@link ScreenPart}.
     * @see #getView()
     */
    @NonNull
    protected abstract View createView();

    /**
     * @return non-null view of this {@link ScreenPart} created earlier in {@link #createView()}.
     * @see #createView();
     */
    @NonNull
    public final View getView() {
        return view;
    }

    /**
     * A callback that may be overridden by a concrete {@link ScreenPart} to save some state.
     *
     * @param bundle non-null {@link Bundle} to place state.
     */
    @CallSuper
    public void saveState(@NonNull Bundle bundle) {

    }
}
