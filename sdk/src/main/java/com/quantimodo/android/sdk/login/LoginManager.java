package com.quantimodo.android.sdk.login;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * Created by Andrés on 08-12-2015.
 */
public class LoginManager {

    private static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(@NonNull final Activity activity) {
            this.activity = activity;
        }

        @Override
        public void startActivityForResult(Intent intent, int requestCode) {
            activity.startActivityForResult(intent, requestCode);
        }

        @Override
        public Activity getActivityContext() {
            return activity;
        }
    }

    private static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final Fragment fragment;

        FragmentStartActivityDelegate(@NonNull final Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void startActivityForResult(Intent intent, int requestCode) {
            fragment.startActivityForResult(intent, requestCode);
        }

        @Override
        public Activity getActivityContext() {
            return fragment.getActivity();
        }
    }
}
