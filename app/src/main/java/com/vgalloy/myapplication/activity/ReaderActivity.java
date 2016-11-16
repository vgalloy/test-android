package com.vgalloy.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vgalloy.myapplication.R;
import com.vgalloy.myapplication.task.TextUpdaterTask;

public class ReaderActivity extends AppCompatActivity {

    private TextUpdaterTask asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        final TextView textView = (TextView) findViewById(R.id.text_main);

        Bundle b = getIntent().getExtras();
        String epubPath = null; // or other values
        if(b != null)
            epubPath = b.getString("epubPath");
        textView.setText("Je vais jouer " + epubPath);



        asyncTask = new TextUpdaterTask(epubPath);
        asyncTask.execute(textView);
    }

    @Override
    protected void onDestroy() {
        // TODO : ordre ?
        asyncTask.cancel(true);
        super.onDestroy();
    }
}
