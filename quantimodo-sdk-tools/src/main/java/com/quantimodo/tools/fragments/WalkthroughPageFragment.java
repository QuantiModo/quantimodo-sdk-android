package com.quantimodo.tools.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.quantimodo.tools.R;

public class WalkthroughPageFragment extends Fragment {
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static WalkthroughPageFragment create(int pageNumber) {
        WalkthroughPageFragment fragment = new WalkthroughPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public WalkthroughPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.qmt_f_walkthrough_page, container, false);

        ImageView image = (ImageView) rootView.findViewById(R.id.walkthrough_image);
        int imageRes = R.drawable.walkthrough_1;
        int contentRes = R.string.walkthrough_content_1;
        switch (mPageNumber){
            case 0:
                imageRes = R.drawable.walkthrough_1;
                contentRes = R.string.walkthrough_content_1;
                break;
            case 1:
                imageRes = R.drawable.walkthrough_2;
                contentRes = R.string.walkthrough_content_2;
                break;
            case 2:
                imageRes = R.drawable.walkthrough_3;
                contentRes = R.string.walkthrough_content_3;
                break;
            case 3:
                imageRes = R.drawable.walkthrough_4;
                contentRes = R.string.walkthrough_content_4;
                break;
            case 4:
                imageRes = R.drawable.walkthrough_5;
                contentRes = R.string.walkthrough_content_5;
                break;
            case 5:
                imageRes = R.drawable.walkthrough_6;
                contentRes = R.string.walkthrough_content_6;
                break;
            case 6:
                imageRes = R.drawable.walkthrough_7;
                contentRes = R.string.walkthrough_content_7;
                break;
        }
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageRes, opts);

        image.setImageBitmap(bitmap);

        TextView contentText = (TextView) rootView.findViewById(R.id.walkthrough_text);
        contentText.setText(contentRes);
        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
