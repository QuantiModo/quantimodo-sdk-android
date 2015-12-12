package com.quantimodo.android.sdk.login.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.quantimodo.android.sdk.login.AuthHelper;
import com.quantimodo.android.sdk.login.NoNetworkConnection;
import com.quantimodo.android.sdk.login.QuantimodoWebAuthenticatorActivity;
import com.quantimodo.android.sdk.R;

/**
 * A Log In/Log Out button that maintains login state and logs in/out for the app.
 * <p/>
 * This control requires the app ID to be specified in the AndroidManifest.xml.
 */
public class LoginButton extends QuantimodoButtonBase {
    private static final String TAG = LoginButton.class.getName();
    private static final int REQUEST_CODE_WEB_AUTHENTICATE = 2;
    private static final int REQUEST_CODE = 5687313;
    private String loginText;
    private String logoutText;
    private boolean toolTipChecked;


    /**
     * Create the LoginButton by inflating from XML
     *
     * @see View#View(Context, AttributeSet)
     */
    public LoginButton(Context context) {
        super(context, null, 0, 0, REQUEST_CODE);
    }

    /**
     * Create the LoginButton by inflating from XML
     *
     * @see View#View(Context, AttributeSet)
     */
    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0, 0, REQUEST_CODE);
    }

    /**
     * Create the LoginButton by inflating from XML and applying a style.
     *
     * @see View#View(Context, AttributeSet, int)
     */
    public LoginButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle, 0, REQUEST_CODE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setButtonText();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!toolTipChecked && !isInEditMode()) {
            toolTipChecked = true;
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setButtonText();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
    }

    @Override
    protected void configureButton(
            final Context context,
            final AttributeSet attrs,
            final int defStyleAttr,
            final int defStyleRes) {
        super.configureButton(context, attrs, defStyleAttr, defStyleRes);
        setInternalOnClickListener(new LoginClickListener());

//        parseLoginButtonAttributes(context, attrs, defStyleAttr, defStyleRes);

        if (isInEditMode()) {
            // cannot use a drawable in edit mode, so setting the background color instead
            // of a background resource.
            setBackgroundColor(getResources().getColor(R.color.qm_button_color));
            // hardcoding in edit mode as getResources().getString() doesn't seem to work in
            // IntelliJ
            loginText = "Log in with QuantiModo";
        }

        setButtonText();
    }

    @Override
    protected int getDefaultStyleResource() {
        return R.style.QM_ButtonStyle;
    }

    //TODO: implement customization later
//    private void parseLoginButtonAttributes(
//            final Context context,
//            final AttributeSet attrs,
//            final int defStyleAttr,
//            final int defStyleRes) {
//        final TypedArray a = context.getTheme().obtainStyledAttributes(
//                attrs,
//                R.styleable.com_quantimodo_login_view,
//                defStyleAttr,
//                defStyleRes);
//        try {
//            loginText = a.getString(R.styleable.com_quantimodo_login_view_com_quantimodo_login_text);
//            logoutText = a.getString(R.styleable.com_quantimodo_login_view_com_quantimodo_logout_text);
//        } finally {
//            a.recycle();
//        }
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
//        int height = (getCompoundPaddingTop() +
//                (int)Math.ceil(Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)) +
//                getCompoundPaddingBottom());
//
//        final Resources resources = getResources();
//        String text = resources.getString(R.string.qm_sdk_button_signin_text_long);
//        int logInWidth;
//        int width;
//
//
//        text = logoutText;
//        if (text == null) {
//            text = resources.getString(R.string.qm_sdk_button_signout_text);
//        }
//        int logOutWidth = measureButtonWidth(text);
//
//        width = resolveSize(Math.max(logInWidth, logOutWidth), widthMeasureSpec);
//        setMeasuredDimension(width, height);
//    }


    private void setButtonText() {
        final Resources resources = getResources();
        try {
            if (!isInEditMode() && AuthHelper.getInstance().getAuthTokenWithRefresh() != null) {
                setText((logoutText != null) ?
                        logoutText :
                        resources.getString(R.string.qm_sdk_button_signout_text));
            } else {
                if (loginText != null) {
                    setText(loginText);
                } else {
                    String text = resources.getString(R.string.qm_sdk_button_signin_text_long);
                    setText(text);
                }
            }
        } catch (NoNetworkConnection ex){

        }
    }

    private class LoginClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            callExternalOnClickListener(v);
            Intent intent = new Intent(getContext(), QuantimodoWebAuthenticatorActivity.class);
            getContext().startActivity(intent);

            /*
            Context context = getContext();

            AccessToken accessToken = AccessToken.getCurrentAccessToken();

            if (accessToken != null) {
                // Log out
                if (confirmLogout) {
                    // Create a confirmation dialog
                    String logout = getResources().getString(
                            R.string.com_quantimodo_loginview_log_out_action);
                    String cancel = getResources().getString(
                            R.string.com_quantimodo_loginview_cancel_action);
                    String message;
                    Profile profile = Profile.getCurrentProfile();
                    if (profile != null && profile.getName() != null) {
                        message = String.format(
                                getResources().getString(
                                        R.string.com_quantimodo_loginview_logged_in_as),
                                profile.getName());
                    } else {
                        message = getResources().getString(
                                R.string.com_quantimodo_loginview_logged_in_using_quantimodo);
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage(message)
                            .setCancelable(true)
                            .setPositiveButton(logout, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    getLoginManager().logOut();
                                }
                            })
                            .setNegativeButton(cancel, null);
                    builder.create().show();
                } else {
                    getLoginManager().logOut();
                }
            } else {
                Intent intent = new Intent(getContext(), QuantimodoWebAuthenticatorActivity.class);
                getContext().startActivityForResult(intent, REQUEST_CODE_WEB_AUTHENTICATE);

                LoginManager loginManager = getLoginManager();

                if (LoginAuthorizationType.PUBLISH.equals(properties.authorizationType)) {
                    if (LoginButton.this.getFragment() != null) {
                        loginManager.logInWithPublishPermissions(
                                LoginButton.this.getFragment(),
                                properties.permissions);
                    } else if (LoginButton.this.getNativeFragment() != null) {
                        loginManager.logInWithPublishPermissions(
                                LoginButton.this.getNativeFragment(),
                                properties.permissions);
                    } else {
                        loginManager.logInWithPublishPermissions(
                                LoginButton.this.getActivity(),
                                properties.permissions);
                    }
                } else {
                    if (LoginButton.this.getFragment() != null) {
                        loginManager.logInWithReadPermissions(
                                LoginButton.this.getFragment(),
                                properties.permissions);
                    } else if (LoginButton.this.getNativeFragment() != null) {
                        loginManager.logInWithReadPermissions(
                                LoginButton.this.getNativeFragment(),
                                properties.permissions);
                    } else {
                        loginManager.logInWithReadPermissions(
                                LoginButton.this.getActivity(),
                                properties.permissions);
                    }
                }
            }

            AppEventsLogger logger = AppEventsLogger.newLogger(getContext());

            Bundle parameters = new Bundle();
            parameters.putInt("logging_in", (accessToken != null) ? 0 : 1);

            logger.logSdkEvent(loginLogoutEventName, null, parameters);
            */
        }
    }
}
