package com.example.anders.android_rk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class OneArticle extends Fragment {

    public OneArticle() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final Bundle bundle = getArguments();
        final LinearLayout view = (LinearLayout) inflater.inflate(R.layout.fragment_one_article, container, false);

        TextView titleView = view.findViewById(R.id.title);
        TextView dateView = view.findViewById(R.id.date);
        TextView textView = view.findViewById(R.id.text);

        titleView.setText(bundle.getString(MainActivity.TITLE));
        dateView.setText(bundle.getString(MainActivity.DATE));
        textView.setText(bundle.getString(MainActivity.TEXT));

        return view;
    }
}
