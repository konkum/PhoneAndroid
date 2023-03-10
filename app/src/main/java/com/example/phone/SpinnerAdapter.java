package com.example.phone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private int phoneIcons[];
    LayoutInflater inflater;

    public SpinnerAdapter(Context context, int[] phoneIcons) {
        this.context = context;
        this.phoneIcons = phoneIcons;
        inflater=(LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return phoneIcons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= inflater.inflate(R.layout.dropdown_item,null);
        ImageView phoneIconView = (ImageView) view.findViewById(R.id.dropdown_image);
        phoneIconView.setImageResource(phoneIcons[i]);
        return view;
    }
}
