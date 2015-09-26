package com.quantimodo.tools.fragments;

import android.app.Fragment;

/**
 * Used by some fragments, to request fragment change
 */
public interface FragmentAdderListener {
    void requestFragmentAdd(Fragment fragment,String title);
    void requestFragmentAdd(int fragmentId,String title);
}
