package com.quantimodo.android.sdk;

/**
 * Created by Andrés on 10-12-2015.
 */
public interface LoginCallback {
    /**
     * Called when the dialog completes without error
     * If the operation was succeed you can get the token from now on using
     * {@link AuthHelper}.getInstance().getAuthTokenWithRefresh()
     */
    public void onSuccess();

    /**
     * Called when the dialog is canceled
     */
    public void onCancel();

    /**
     * Called when the dialog finishes with an error
     * @param error The error that occurred
     */
    public void onError(String error);

}
