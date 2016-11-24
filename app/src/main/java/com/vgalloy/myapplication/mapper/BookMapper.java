package com.vgalloy.myapplication.mapper;

import android.util.Xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.vgalloy.myapplication.model.SimpleBook;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
 */
public final class BookMapper {

    /**
     * Constructor.
     * To prevent instantiation
     */
    private BookMapper() {
        throw new AssertionError();
    }

    /**
     * Map the complex {@link Book} object into a simple one
     *
     * @param book the book
     * @return the simple book
     */
    public static SimpleBook map(Book book) {
        Objects.requireNonNull(book);
        List<String> wordList = new ArrayList<>();

        for (Resource resource : book.getContents()) {
            List<String> words = parse(resource);
            wordList.addAll(words);
        }
        return new SimpleBook(wordList);
    }

    /**
     * Extract all word from a resource
     *
     * @param resource
     * @return
     */
    private static List<String> parse(Resource resource) {
        List<String> sentenceList = new ArrayList<>();
        XmlPullParser parser = Xml.newPullParser();

        try {
            String tmp = new String(resource.getData());

//            Serializer serializer = new Persister();
            XmlMapper xmlMapper = new XmlMapper();
//            xmlMapper.readValue(resource.getInputStream(), HTMLBook.class);

            return Collections.singletonList(tmp);

//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(resource.getInputStream(), null);
//            parser.nextTag();
//            while (parser.next() != XmlPullParser.END_TAG) {
//                if (parser.getEventType() != XmlPullParser.START_TAG) {
//                    continue;
//                }
//                String name = parser.getName();
//                if (name.equals("body")) {
//                    String sentence = readBody(parser);
//                    sentenceList.add(sentence);
//                } else {
//                    skip(parser);
//                }
//            }
//            System.out.println(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sentenceList;
    }

    private static String readBody(XmlPullParser parser) throws IOException, XmlPullParserException {

        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getInputEncoding();
            parser.nextTag();
        }
        return result;
    }

    private static void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
