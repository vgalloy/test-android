package com.vgalloy.myapplication.model;


/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
 */
public final class WordGenerator {

    private final SimpleBook simpleBook;
    private int index = 0;

    public WordGenerator(SimpleBook simpleBook) {
        this.simpleBook = simpleBook;
    }

    public String nextWord() {
        if (index < simpleBook.getWordList().size()) {
            return simpleBook.getWordList().get(index++);
        }
        return "";
    }
}
