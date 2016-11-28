package com.vgalloy.myapplication.task;

import android.graphics.Color;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.vgalloy.myapplication.mapper.BookMapper;
import com.vgalloy.myapplication.model.FakeBookGenerator;
import com.vgalloy.myapplication.model.SimpleBook;
import com.vgalloy.myapplication.model.WordGenerator;
import com.vgalloy.myapplication.service.BookService;
import com.vgalloy.myapplication.service.impl.BookServiceImpl;

import java.util.Objects;

import nl.siegmann.epublib.domain.Book;

/**
 * @author Vincent Galloy Created by Vincent Galloy on 08/11/2016.
 */

public class TextUpdaterTask extends AsyncTask<TextView, Integer, Long> {

    private static final int SLEEPING_TIME_MILLIS = 150;
    private final WordGenerator wordGenerator;
    private TextView textView;

    public TextUpdaterTask(String epubPath) {
        BookService bookService = BookServiceImpl.INSTANCE;
        Book book = bookService.getBook(epubPath);
        SimpleBook simpleBook = BookMapper.map(book);
//        this.wordGenerator = new WordGenerator(simpleBook);
        this.wordGenerator = new WordGenerator(FakeBookGenerator.fakeBook());
    }

    @Override
    protected Long doInBackground(TextView... textViews) {
        Objects.requireNonNull(textViews);
        if (textViews.length != 1) {
            throw new IllegalStateException("Ups"); // TODO Perso Exception ?
        }

        textView = textViews[0];

        while (true) {
            // TODO Necessaire ?
            if (isCancelled()) {
                return 1L;
            }
            try {
                Thread.sleep(SLEEPING_TIME_MILLIS);
                publishProgress(1);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        if (textView != null) {
            String word = wordGenerator.nextWord();

            // TODO process de mise en forme à faire ici ou à l'aide d'un {{data | filter}} dans la vue ?
            if (word.length() % 2 == 0) {
                word = " " + word;
            }
            SpannableString text = new SpannableString(word);

            int redLetter = Math.max((word.length() + 1) / 2, 1);

            text.setSpan(new ForegroundColorSpan(Color.RED), redLetter - 1, redLetter, 0);
            textView.setText(text, TextView.BufferType.SPANNABLE);
        }
    }
}
