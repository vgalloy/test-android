package com.vgalloy.myapplication.model;

import java.util.List;

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public final class SimpleBook {

    private final List<String> wordList;

    public SimpleBook(List<String> wordList) {
        this.wordList = wordList;
    }

    public List<String> getWordList() {
        return wordList;
    }
}
