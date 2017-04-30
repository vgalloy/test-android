package com.vgalloy.myapplication.service.impl;

import com.vgalloy.myapplication.service.BookService;
import com.vgalloy.myapplication.service.exception.ServiceException;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public enum BookServiceImpl implements BookService {
    INSTANCE;

    @Override
    public Book getBook(String path) {
        Objects.requireNonNull(path);
        File file = new File(path);
        try {
            InputStream inputStream = new FileInputStream(file);
            return new EpubReader().readEpub(inputStream);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
