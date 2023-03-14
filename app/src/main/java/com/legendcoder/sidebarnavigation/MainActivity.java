package com.legendcoder.sidebarnavigation;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mSmartSidebar;
    private GestureDetectorCompat mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the smart sidebar
        mSmartSidebar = findViewById(R.id.smart_sidebar);
        mGestureDetector = new GestureDetectorCompat(this, new GestureListener());

        // Add click listeners to the navigation icons
        ImageView navigationIcon1 = findViewById(R.id.navigation_icon_1);
        ImageView navigationIcon2 = findViewById(R.id.navigation_icon_2);
        ImageView navigationIcon3 = findViewById(R.id.navigation_icon_3);
        ImageView navigationIcon4 = findViewById(R.id.navigation_icon_4);

        navigationIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for navigation icon 1
            }
        });

        navigationIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for navigation icon 2
            }
        });

        navigationIcon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for navigation icon 3
            }
        });

        navigationIcon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for navigation icon 4
            }
        });

        // Add a touch listener to the root view to hide the sidebar when someone clicks anywhere on the screen
        View rootView = findViewById(android.R.id.content);
        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideSidebar();
                return false;
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // Handle touch events to show/hide the smart sidebar
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    private void showSidebar() {
        mSmartSidebar.setVisibility(View.VISIBLE);
    }

    private void hideSidebar() {
        mSmartSidebar.setVisibility(View.GONE);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY) && Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    showSidebar();
                } else {
                    hideSidebar();
                }
                return true;
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
