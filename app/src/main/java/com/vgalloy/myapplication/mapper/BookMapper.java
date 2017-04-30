package com.vgalloy.myapplication.mapper;

import com.vgalloy.myapplication.model.SimpleBook;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.util.StringUtil;

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public final class BookMapper {

    private static final BookMapper INSTANCE = new BookMapper();

    /**
     * Constructor.
     * To prevent external instantiation
     */
    private BookMapper() {

    }

    public static BookMapper getInstance() {
        return INSTANCE;
    }

    /**
     * Map the complex {@link Book} object into a simple one
     *
     * @param book the book
     * @return the simple book
     */
    public SimpleBook map(Book book) {
        Objects.requireNonNull(book);
        List<String> wordList = new ArrayList<>();

        for (Resource resource : book.getContents()) {
            List<String> words = parse(resource);
            wordList.addAll(words);
        }
        return new SimpleBook(wordList);
    }

    private List<String> parse(Resource resource) {
        List<String> sentenceList = new ArrayList<>();

        try {
            String tmp = new String(resource.getData());
            Document document = Jsoup.parse(tmp);
            parse(sentenceList, document.childNodes());
            return sentenceList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sentenceList;
    }

    private void parse(List<String> sentenceList, List<Node> nodes) {
        Objects.requireNonNull(sentenceList);
        Objects.requireNonNull(nodes);

        for (Node node : nodes) {
            parse(sentenceList, node);
        }
    }

    private void parse(List<String> sentenceList, Node node) {
        Objects.requireNonNull(sentenceList);
        Objects.requireNonNull(node);

        if (node instanceof TextNode) {
            String text = ((TextNode) node).getWholeText();
            List<String> words = extractWord(text);
            sentenceList.addAll(words);
        } else {
            parse(sentenceList, node.childNodes());
        }
    }

    private List<String> extractWord(String text) {
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
