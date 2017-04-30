package com.vgalloy.myapplication.mapper.text;

import java.util.List;

/**
 * Created by Vincent Galloy on 30/04/2017.
 * This class is Thread-safe
 *
 * @author Vincent Galloy
 */
public interface TextParser {

    /**
     * Transform a String representing a list of word into a list of word.
     *
     * @param text the list a word as a single String
     * @return the word as a list of String
     */
    List<String> parse(String text);
}
