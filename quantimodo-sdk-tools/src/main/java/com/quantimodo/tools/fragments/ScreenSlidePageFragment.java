package com.quantimodo.tools.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.quantimodo.tools.R;

public class ScreenSlidePageFragment extends Fragment {
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
    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.qmt_f_walkthrough_page, container, false);

        // Set the title view to show the page number.
//        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                String.format("test string fragment %s", mPageNumber + 1));

        ImageView image = (ImageView) rootView.findViewById(R.id.walkthrough_image);
        int imageRes = R.drawable.walkthrough_1;
        switch (mPageNumber){
            case 0:
                imageRes = R.drawable.walkthrough_1;
                break;
            case 1:
                imageRes = R.drawable.walkthrough_2;
                break;
            case 2:
                imageRes = R.drawable.walkthrough_3;
                break;
            case 3:
                imageRes = R.drawable.walkthrough_4;
                break;
            case 4:
                imageRes = R.drawable.walkthrough_5;
                break;
            case 5:
                imageRes = R.drawable.walkthrough_6;
                break;
        }
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageRes, opts);

        image.setImageBitmap(bitmap);
//        image.setImageResource(imageRes);
        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
