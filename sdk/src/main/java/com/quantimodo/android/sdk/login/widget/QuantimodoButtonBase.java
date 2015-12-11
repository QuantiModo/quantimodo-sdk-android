package com.quantimodo.android.sdk.login.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.quantimodo.android.sdk.R;

public abstract class QuantimodoButtonBase extends Button {
    private OnClickListener externalOnClickListener;
    private OnClickListener internalOnClickListener;
    private Fragment parentFragment;
    private int requestCode;

    protected QuantimodoButtonBase(
            final Context context,
            final AttributeSet attrs,
            int defStyleAttr,
            int defStyleRes,
            final int requestCode) {
        super(context, attrs, 0);
        defStyleRes = (defStyleRes == 0 ? this.getDefaultStyleResource() : defStyleRes);
        defStyleRes = (defStyleRes == 0 ? R.style.QM_ButtonStyle : defStyleRes);
        configureButton(context, attrs, defStyleAttr, defStyleRes);
        this.requestCode = requestCode;
    }

    /**
     * Sets the fragment that contains this control. This allows the button to be embedded inside a
     * Fragment, and will allow the fragment to receive the
     * {@link Fragment#onActivityResult(int, int, android.content.Intent) onActivityResult}
     * call rather than the Activity.
     *
     * @param fragment the fragment that contains this control
     */
    public void setFragment(final Fragment fragment) {
        parentFragment = fragment;
    }

    /**
     * Gets the fragment that contains this control.
     *
     * @return The fragment that contains this control.
     */
    public Fragment getFragment() {
        return parentFragment;
    }

    @Override
    public void setOnClickListener(final OnClickListener l) {
        this.externalOnClickListener = l;
    }

    /**
     * Set the request code for the startActivityForResult call.
     *
     * @param requestCode the request code to use.
     */
    protected void setRequestCode(final int requestCode) {
        this.requestCode = requestCode;
    }

    /**
     * Returns the request code used for this Button.
     *
     * @return the request code.
     */
    public int getRequestCode() {
        return requestCode;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected Activity getActivity() throws Exception {
        final Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        } else if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        throw new Exception("Unable to get Activity.");
    }

    protected int getDefaultStyleResource() {
        return 0;
    }

    protected void configureButton(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        parseBackgroundAttributes(context, attrs, defStyleAttr, defStyleRes);
        parseCompoundDrawableAttributes(context, attrs, defStyleAttr, defStyleRes);
        parseContentAttributes(context, attrs, defStyleAttr, defStyleRes);
        parseTextAttributes(context, attrs, defStyleAttr, defStyleRes);
        setupOnClickListener();
    }

    protected void callExternalOnClickListener(final View v) {
        if (externalOnClickListener != null) {
            externalOnClickListener.onClick(v);
        }
    }

    protected void setInternalOnClickListener(final OnClickListener l) {
        internalOnClickListener = l;
    }

    private void parseBackgroundAttributes(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        final int attrsResources[] = {
                android.R.attr.background,
        };
        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                attrsResources,
                defStyleAttr,
                defStyleRes);
        try {
            if (a.hasValue(0)) {
                int backgroundResource = a.getResourceId(0, 0);
                if (backgroundResource != 0) {
                    setBackgroundResource(backgroundResource);
                } else {
                    setBackgroundColor(a.getColor(0, 0));
                }
            } else {
                // if no background specified, use the default one
                setBackgroundColor(a.getColor(0, getResources().getColor(R.color.qm_button_color)));
            }
        } finally {
            a.recycle();
        }
    }

    private void parseCompoundDrawableAttributes(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        final int attrsResources[] = {
                android.R.attr.drawableLeft,
                android.R.attr.drawableTop,
                android.R.attr.drawableRight,
                android.R.attr.drawableBottom,
                android.R.attr.drawablePadding,
        };
        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                attrsResources,
                defStyleAttr,
                defStyleRes);
        try {
            setCompoundDrawablesWithIntrinsicBounds(
                    a.getResourceId(0, 0),
                    a.getResourceId(1, 0),
                    a.getResourceId(2, 0),
                    a.getResourceId(3, 0));
            setCompoundDrawablePadding(a.getDimensionPixelSize(4, 0));

        } finally {
            a.recycle();
        }
    }

    private void parseContentAttributes(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        final int attrsResources[] = {
                android.R.attr.paddingLeft,
                android.R.attr.paddingTop,
                android.R.attr.paddingRight,
                android.R.attr.paddingBottom,
        };
        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                attrsResources,
                defStyleAttr,
                defStyleRes);
        try {
            setPadding(
                    a.getDimensionPixelSize(0, 0),
                    a.getDimensionPixelSize(1, 0),
                    a.getDimensionPixelSize(2, 0),
                    a.getDimensionPixelSize(3, 0));
        } finally {
            a.recycle();
        }
    }

    private void parseTextAttributes(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        final int colorResources[] = {
                android.R.attr.textColor,
        };
        final TypedArray colorAttrs = context.getTheme().obtainStyledAttributes(
                attrs,
                colorResources,
                defStyleAttr,
                defStyleRes);
        try {
            setTextColor(colorAttrs.getColor(0, Color.WHITE));
        } finally {
            colorAttrs.recycle();
        }
        final int gravityResources[] = {
                android.R.attr.gravity,
        };
        final TypedArray gravityAttrs = context.getTheme().obtainStyledAttributes(
                attrs,
                gravityResources,
                defStyleAttr,
                defStyleRes);
        try {
            setGravity(gravityAttrs.getInt(0, Gravity.CENTER));
        } finally {
            gravityAttrs.recycle();
        }
        final int attrsResources[] = {
                android.R.attr.textSize,
                android.R.attr.textStyle,
                android.R.attr.text,
        };
        final TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                attrsResources,
                defStyleAttr,
                defStyleRes);
        try {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, a.getDimensionPixelSize(0, 0));
            setTypeface(Typeface.defaultFromStyle(a.getInt(1, Typeface.BOLD)));
            setText(a.getString(2));
        } finally {
            a.recycle();
        }
    }

    private void setupOnClickListener() {
        // set the listener on super so that consumers can set another listener that this will
        // forward to
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                //TODO: fix this
                if (QuantimodoButtonBase.this.internalOnClickListener != null) {
                    QuantimodoButtonBase.this.internalOnClickListener.onClick(v);
                } else if (QuantimodoButtonBase.this.externalOnClickListener != null) {
                    QuantimodoButtonBase.this.externalOnClickListener.onClick(v);
                }
            }
        });
    }
}