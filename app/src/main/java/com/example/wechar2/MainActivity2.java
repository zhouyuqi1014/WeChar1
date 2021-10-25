package com.example.wechar2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("life","another_item is starting...");
        Intent intent = getIntent();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","Activity2 is starting...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","Activity2 is stopping...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","Activity2 is stopping...");
    }

}