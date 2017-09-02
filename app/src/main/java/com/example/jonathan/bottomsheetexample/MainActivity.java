package com.example.jonathan.bottomsheetexample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llBottomSheet;
    private BottomSheetBehavior llBottomSheetBehavior;

    private FloatingActionButton fabDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomSheet();
        initFab();
    }

    private void initBottomSheet(){
        llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);
        llBottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);
        llBottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        llBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                    fabDetails.animate().scaleX(1).scaleY(1).setDuration(300).start();
                } else if (BottomSheetBehavior.STATE_EXPANDED == newState) {
                    fabDetails.animate().scaleX(0).scaleY(0).setDuration(300).start();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) { }
        });
    }

    private void initFab() {
        fabDetails = (FloatingActionButton) findViewById(R.id.fab_camera);
        fabDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
    }
}
