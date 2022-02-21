package com.example.zoomcontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);
        zoomControls = findViewById(R.id.zoom_controls);
        zoomControls.hide();

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                zoomControls.show();
                return false;
            }
        });

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();
                imageView.setScaleX((float) (x+1));
                imageView.setScaleY((float) (y+1));
                zoomControls.hide();

            }
        });

        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();
                if (x == 1 && y ==1){
                    imageView.setScaleX(x);
                    imageView.setScaleY(y);
                }else {
                    imageView.setScaleX((float) (x-1));
                    imageView.setScaleY((float) (y-1));
                    zoomControls.hide();

                }
            }
        });
    }
}