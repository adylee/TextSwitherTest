package com.example.administrator.textswithertest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    TextSwitcher textSwitcher;
    String[] strs = new String[]
            {
                    "aa",
                    "bb",
                    "cc",
                    "dd"
            };
    int curStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            public View makeView()
            {
                TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return  tv;
            }
        });
        next(null);
    }
    public void next(View source)
    {
        textSwitcher.setText(strs[curStr++ % strs.length]);
    }
}
