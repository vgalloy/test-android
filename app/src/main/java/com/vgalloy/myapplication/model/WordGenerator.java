package com.vgalloy.myapplication.model;

import java.util.Objects;

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public final class WordGenerator {

    private final SimpleBook simpleBook;
    private int index = 0;

    public WordGenerator(SimpleBook simpleBook) {
        this.simpleBook = Objects.requireNonNull(simpleBook);
    }

    public String nextWord() {
        if (index < simpleBook.getWordList().size()) {
            return simpleBook.getWordList().get(index++);
        }
        return "end : " + index++;
    }
}
