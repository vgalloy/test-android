package com.vgalloy.myapplication.model;

import java.util.List;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
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
