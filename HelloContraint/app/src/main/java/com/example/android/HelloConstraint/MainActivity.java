package com.example.android.HelloConstraint;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mButtonZero;
    private Button mButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        mButtonZero = (Button) findViewById(R.id.button_zero);
        mButtonCount = (Button) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        mButtonZero.setBackgroundColor(Color.parseColor("#FFC0CB"));
        if(mCount % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#6200EE"));
        }else{
            view.setBackgroundColor(Color.parseColor("#008000"));
        }
    }

    public void setZero(View view) {
        mCount = 0;
        if(mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
        view.setBackgroundColor(Color.parseColor("#A9A9A9"));
        mButtonCount.setBackgroundColor(Color.parseColor("#6200EE"));
    }
}
