package com.vgalloy.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vgalloy.myapplication.R;
import com.vgalloy.myapplication.task.ListBookTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * @author Vincent Galloy Created by Vincent Galloy on 11/11/2016.
 */

public class ChooseActivity extends AppCompatActivity {
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        listview = (ListView) findViewById(R.id.listview);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapter.getItem(position);

                File sdcard = Environment.getExternalStorageDirectory();
                String pathToDownload = sdcard.getAbsolutePath() + "/Download";
                String epubPath = pathToDownload + "/" + item;

                Intent intent = new Intent(ChooseActivity.this, ReaderActivity.class);
                intent.putExtras(ReaderActivity.getBundle(epubPath));
                startActivity(intent);
            }
        });

        asyncGetText();
    }

    private void asyncGetText() {
        new ListBookTask(listview).execute();
    }
}
