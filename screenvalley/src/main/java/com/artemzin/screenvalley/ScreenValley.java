package com.artemzin.screenvalley;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.artemzin.screenvalley.internal.Checks.checkNotNull;

public class ScreenValley {

    @NonNull
    private final Activity activity;

    @NonNull
    private final List<BackStackEntry> backStackEntries = new ArrayList<>(0);

    private ScreenValley(@NonNull Activity activity, @Nullable Bundle previousState) {
        this.activity = activity;
    }

    @NonNull
    public Activity activity() {
        return activity;
    }

    public void showScreen(@NonNull Screen screen) {

    }

    public int backStackSize() {
        return backStackEntries.size();
    }

    public static class Builder0 {

        @NonNull
        public Builder1 activity(@NonNull Activity activity) {
            checkNotNull(activity, "Activity must not be null");
            return new Builder1(activity);
        }
    }

    @NonNull
    public static Builder0 builder() {
        return new Builder0();
    }

    public static class Builder1 {

        @NonNull
        private final Activity activity;

        Builder1(@NonNull Activity activity) {
            this.activity = activity;
        }

        @NonNull
        public Builder2 previousState(@Nullable Bundle previousState) {
            return new Builder2(activity, previousState);
        }
    }

    public static class Builder2 {

        @NonNull
        private final Activity activity;

        @Nullable
        private final Bundle previousState;

        Builder2(@NonNull Activity activity, @Nullable Bundle previousState) {
            this.activity = activity;
            this.previousState = previousState;
        }

        @NonNull
        public ScreenValley build() {
            return new ScreenValley(activity, previousState);
        }
    }
}
