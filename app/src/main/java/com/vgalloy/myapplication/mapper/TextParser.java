package com.vgalloy.myapplication.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Vincent Galloy
 *         Created by vgalloy on 28/11/16.
 */
public final class TextParser {

    /**
     * Constructor.
     * To prevent instantiation
     */
    private TextParser() {
        throw new AssertionError();
    }

    /**
     * Transform a String representing a list of word into a list of word.
     *
     * @param string the list a word as a single String
     * @return the word as a list of String
     */
    public static List<String> parse(String string) {
        Objects.requireNonNull(string);
        return Arrays.asList(string.split(" "));
    }
}
