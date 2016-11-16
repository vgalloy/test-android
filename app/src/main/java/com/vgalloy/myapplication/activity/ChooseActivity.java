package com.vgalloy.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vgalloy.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
 */

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // TODO Beurk : 1. Logique dans la vue 2. "Download" ecrit en clair
        File sdcard = Environment.getExternalStorageDirectory();
        String pathToDownload = sdcard.getAbsolutePath() + "/Download";
        File downloadDirectory = new File(pathToDownload);

        final ListView listview = (ListView) findViewById(R.id.listview);

        // TODO Peut être faudrait il faire un vrai model avec un adapter !
        final List<String> list = new ArrayList<>();
        for (String fileName : downloadDirectory.list()) {
            String[] ext = fileName.split("\\.");
            String extension = ext[ext.length - 1];
            if ("epub".equals(extension)) {
                list.add(fileName);
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapter.getItem(position);

                System.out.println("item" + item);

                Intent intent = new Intent(ChooseActivity.this, ReaderActivity.class);

                File sdcard = Environment.getExternalStorageDirectory();
                String pathToDownload = sdcard.getAbsolutePath() + "/Download";
                String epubPath = pathToDownload + "/" + item;

                // TODO Le pass-param ce fait via une map ? WTF ... comment voir les erreurs à la compilation.
                Bundle b = new Bundle();
                b.putString("epubPath", epubPath); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }
        });
    }
}
