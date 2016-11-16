package com.vgalloy.myapplication.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.vgalloy.myapplication.R;
import com.vgalloy.myapplication.task.TextUpdaterTask;

public class ReaderActivity extends AppCompatActivity {

    private TextUpdaterTask asyncTask;
    private TextView textView;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        textView = (TextView) findViewById(R.id.text_main);

        Bundle b = getIntent().getExtras();
        String epubPath = null; // or other values
        if(b != null){
            epubPath = b.getString("EPUBPATH");
        }
        textView.setText("Je vais jouer " + epubPath);

        //todo remove and use handler
        //asyncTask = new TextUpdaterTask(epubPath);
        //asyncTask.execute(textView);

        runnable = new Runnable() {
            public void run() {
                displayText("");
            }
        };

        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 1000);

    }

    public void displayText(String text) {
        Toast.makeText(this, "fdsfsd", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }



}
