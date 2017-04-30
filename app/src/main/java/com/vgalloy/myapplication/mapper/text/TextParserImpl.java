package com.vgalloy.myapplication.mapper.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nl.siegmann.epublib.util.StringUtil;

/**
 * Created by Vincent Galloy on 28/11/16.
 *
 * @author Vincent Galloy
 */
public final class TextParserImpl implements TextParser {

    @Override
    public List<String> parse(String text) {
        Objects.requireNonNull(text);
        List<String> worlds = new ArrayList<>();
        for (String word : text.split(" ")) {
            String trimWord = word.trim();
            if (!StringUtil.isBlank(trimWord)) {
                worlds.add(trimWord);
            }
        }
        return worlds;
    }
}
