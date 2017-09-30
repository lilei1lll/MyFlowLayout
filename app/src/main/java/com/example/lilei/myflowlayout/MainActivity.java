package com.example.lilei.myflowlayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lilei.utils.FlowLayout;

public class MainActivity extends AppCompatActivity {

    FlowLayout flowLayout;

    String[] texts = new String[]{
            "good", "bad", "understand", "it is a good day !",
            "how are you", "ok", "fine", "name", "momo",
            "lankton", "lan", "flowlayout demo", "soso"
    };

    int length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        length = texts.length;
        flowLayout = (FlowLayout) findViewById(R.id.flowlayout);

        for (int i = 0;i< 12;i++){
            int ranHeight = dip2px(this, 30);
            ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);        lp.setMargins(dip2px(this, 10), 0, dip2px(this, 10), 0);
            TextView tv = new TextView(this);
            tv.setPadding(dip2px(this, 15), 0, dip2px(this, 15), 0);
            tv.setTextColor(Color.parseColor("#FF3030"));
            tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
            int index = (int)(Math.random() * length);
            tv.setText(texts[index]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setLines(1);
            flowLayout.addView(tv, lp);
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
