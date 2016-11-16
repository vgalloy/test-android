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
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * @author Vincent Galloy Created by Vincent Galloy on 11/11/2016.
 */

public class ChooseActivity extends AppCompatActivity {
  private ListView listview;
  public static final String EPUBPATH = "EPUBPATH";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //get the view
    setContentView(R.layout.activity_choose);
    listview = (ListView) findViewById(R.id.listview);

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

        //// TODO: 17/11/2016 extract in activity with function getBundle
        Bundle b = new Bundle();
        b.putString(ChooseActivity.EPUBPATH, epubPath); //Your id
        intent.putExtras(b); //Put your id to your next Intent
        startActivity(intent);
      }
    });

    //get data (async)
    asyncGetText();
  }

  private void asyncGetText() {
    File sdcard = Environment.getExternalStorageDirectory();
    String pathToDownload = sdcard.getAbsolutePath() + "/Download";
    File downloadDirectory = new File(pathToDownload);

    final List<String> list = new ArrayList<>();
    for (String fileName : downloadDirectory.list()) {
      String[] ext = fileName.split("\\.");
      String extension = ext[ext.length - 1];
      if ("epub".equals(extension)) {
        list.add(fileName);
      }
    }

    //todo setdata in list
  }
}
