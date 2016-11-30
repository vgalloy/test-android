package com.vgalloy.myapplication.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.vgalloy.myapplication.R;
import com.vgalloy.myapplication.task.TextUpdaterTask;

import java.util.Objects;

public class ReaderActivity extends AppCompatActivity {

    private static final String EPUBPATH = "EPUBPATH";

    private Handler handler = new Handler();
    private Runnable runnable;

    private TextUpdaterTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        TextView textView = (TextView) findViewById(R.id.text_main);

        Bundle b = getIntent().getExtras();
        String epubPath = null;
        if (b != null) {
            epubPath = b.getString(ReaderActivity.EPUBPATH);
        }

        //todo remove and use handler
        asyncTask = new TextUpdaterTask(epubPath);
        asyncTask.execute(textView);

//        runnable = new Runnable() {
//            public void run() {
//                displayText("");
//            }
//        };

        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        asyncTask.cancel(true);
        super.onDestroy();
    }

    public static Bundle getBundle(String epubPath) {
        Objects.requireNonNull(epubPath);
        Bundle bundle = new Bundle();
        bundle.putString(ReaderActivity.EPUBPATH, epubPath);
        return bundle;
    }
}
