package com.vgalloy.myapplication.task;

import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.Objects;

/**
 * Created by Vincent Galloy on 08/11/2016.
 *
 * @author Vincent Galloy
 */
public class ListBookTask extends AsyncTask<Void, String, Integer> {

    private final ListView listView;

    public ListBookTask(ListView listView) {
        this.listView = Objects.requireNonNull(listView);
    }

    @Override
    protected Integer doInBackground(Void... textViews) {
        Objects.requireNonNull(textViews);

        File sdcard = Environment.getExternalStorageDirectory();
        String pathToDownload = sdcard.getAbsolutePath() + "/Download";
        File downloadDirectory = new File(pathToDownload);

        for (String fileName : downloadDirectory.list()) {
            String[] ext = fileName.split("\\.");
            String extension = ext[ext.length - 1];
            if ("epub".equals(extension)) {
                publishProgress(fileName);
            }
        }

        return 0;
    }

    @Override
    protected void onProgressUpdate(String... progress) {
        Objects.requireNonNull(progress);
        ((ArrayAdapter<String>) listView.getAdapter()).addAll(progress);
    }
}
