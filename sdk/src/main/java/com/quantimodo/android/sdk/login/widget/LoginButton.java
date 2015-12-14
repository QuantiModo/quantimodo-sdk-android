package com.quantimodo.android.sdk.login.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.quantimodo.android.sdk.R;
import com.quantimodo.android.sdk.login.LoginManager;

/**
 * Custom button to sign in
 */
public class LoginButton extends Button {
    enum AttributeType{
        BACKGROUND,
        TEXT_COLOR,
        TEXT
    }

    private static final int BG_COLOR = 0xff48BDD1;
    private OnClickListener externalOnClickListener;
    private OnClickListener internalOnClickListener;
    private Fragment parentFragment;

    public LoginButton (Context context, AttributeSet attrs) {
        super(context, attrs);

        setAttr(context, attrs, new int[]{android.R.attr.background}, AttributeType.BACKGROUND);
        setAttr(context, attrs, new int[]{android.R.attr.textColor}, AttributeType.TEXT_COLOR);
        setAttr(context, attrs, new int[]{android.R.attr.text}, AttributeType.TEXT);
        internalOnClickListener = new LoginClickListener();
    }


    private void setAttr(Context context, AttributeSet attrs, int[] attrsResources, AttributeType type){
        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                attrsResources,
                0,
                0);
        try {
            switch (type){
                case BACKGROUND:
                    int backgroundResource = a.getResourceId(0, 0);
                    if (backgroundResource != 0)
                        setBackgroundResource(backgroundResource);
                    else setBackgroundColor(a.getColor(0, BG_COLOR));
                    break;
                case TEXT_COLOR:
                    setTextColor(a.getColor(0, Color.WHITE));
                    break;
                case TEXT:
                    if(TextUtils.isEmpty(a.getString(0))) setText("Sign in with Quantimodo");
                    else setText(a.getString(0));
                    break;
            }
        } finally {
            a.recycle();
        }
    }

    @Override
    public void setOnClickListener(final OnClickListener l) {
        this.externalOnClickListener = l;
    }

    private class LoginClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            if (LoginButton.this.getFragment() != null) {
                LoginManager.getInstance().performLogin(LoginButton.this.getFragment());
            }
            else LoginManager.getInstance().performLogin(LoginButton.this.getActivity());
        }
    }

    public Fragment getFragment() {
        return parentFragment;
    }

    public void setFragment(Fragment parentFragment) {
        this.parentFragment = parentFragment;
    }

    private void setupOnClickListener() {
        // set the listener on super so that consumers can set another listener that this will
        // forward to
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                //TODO: fix this
                if (LoginButton.this.internalOnClickListener != null) {
                    LoginButton.this.internalOnClickListener.onClick(v);
                } else if (LoginButton.this.externalOnClickListener != null) {
                    LoginButton.this.externalOnClickListener.onClick(v);
                }
            }
        });
    }

    protected Activity getActivity() {
        final Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        throw new RuntimeException("Unable to get Activity.");
    }
}
