package com.vgalloy.myapplication.mapper.book;

import com.vgalloy.myapplication.mapper.text.TextParser;
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

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public final class BookMapperImpl implements BookMapper {

    private final TextParser textParser;

    public BookMapperImpl(TextParser textParser) {
        this.textParser = Objects.requireNonNull(textParser);
    }

    @Override
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
            List<String> words = textParser.parse(text);
            sentenceList.addAll(words);
        } else {
            parse(sentenceList, node.childNodes());
        }
    }
}
