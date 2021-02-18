package com.dfan.learningapp;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;

public class Chapter3 extends AppCompatActivity
{

    ViewPager2 myViewPager2;
    MyAdapter3 MyAdapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chapter3);
        myViewPager2 = findViewById(R.id.viewpager);
        MyAdapter3 = new MyAdapter3(this);
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2.setAdapter(MyAdapter3);
        myViewPager2.setOffscreenPageLimit(3);

        float pageMargin= getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        float pageOffset = getResources().getDimensionPixelOffset(R.dimen.offset);

        myViewPager2.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float myOffset = position * -(2 * pageOffset + pageMargin);
                if (myViewPager2.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL)
                {
                    if (ViewCompat.getLayoutDirection(myViewPager2) == ViewCompat.LAYOUT_DIRECTION_RTL)
                    {
                        page.setTranslationX(-myOffset);
                    }
                    else
                    {
                        page.setTranslationX(myOffset);
                    }
                }
                else
                {
                    page.setTranslationY(myOffset);
                }
            }
        });
    }
}
