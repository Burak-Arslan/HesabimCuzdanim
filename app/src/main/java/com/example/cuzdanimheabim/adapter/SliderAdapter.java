package com.example.cuzdanimheabim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cuzdanimheabim.R;

public class SliderAdapter extends PagerAdapter {

    Context context;

    LayoutInflater layoutInflater;

    int images[] = {
            R.drawable.answer,
            R.drawable.calculating,
            R.drawable.checklist,
            R.drawable.trade
    };

    int headings[] = {
            R.string.onBoardSayfaBirBaslik,
            R.string.onBoardSayfaIkiBaslik,
            R.string.onBoardSayfaUcBaslik,
            R.string.onBoardSayfaDortBaslik
    };

    int descriptions[] = {
            R.string.onBoardSayfaBirAciklama,
            R.string.onBoardSayfaIkiAciklama,
            R.string.onBoardSayfaUcAciklama,
            R.string.onBoardSayfaDortAciklama
    };

    public SliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ScrollView) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imageView = view.findViewById(R.id.imgSlide);
        TextView txtHeading = view.findViewById(R.id.txtSlideHeading);
        TextView txtDescription = view.findViewById(R.id.txtSlideDesc);

        imageView.setImageResource(images[position]);
        txtHeading.setText(headings[position]);
        txtDescription.setText(descriptions[position]);

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ScrollView) object);

    }
}
