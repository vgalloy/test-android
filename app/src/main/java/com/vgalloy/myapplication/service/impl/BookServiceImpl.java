package com.vgalloy.myapplication.service.impl;

import com.vgalloy.myapplication.service.BookService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
 */
public enum BookServiceImpl implements BookService {
    INSTANCE;

    @Override
    public Book getBook(String path) {
        // FIXME : fail fast
        // TODO System de loading ?
        System.out.println("Je load le book : " + path);
        File file = new File(path);
        try {
            InputStream inputStream = new FileInputStream(file);
            return new EpubReader().readEpub(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
