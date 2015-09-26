package com.quantimodo.tools.fragments;


import android.app.Activity;
import android.app.Fragment;
import com.octo.android.robospice.SpiceManager;
import com.quantimodo.tools.QTools;

/**
 * Base class for fragments
 * Creates SpiceManager to use RoboSpice
 */
public abstract class QFragment extends Fragment {

    protected SpiceManager mSpiceManager = new SpiceManager(QTools.getInstance().getServiceClass());

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSpiceManager.start(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSpiceManager.shouldStop();
    }

    protected SpiceManager getSpiceManager(){
        return mSpiceManager;
    }
}
