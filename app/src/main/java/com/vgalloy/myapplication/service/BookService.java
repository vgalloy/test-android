package com.vgalloy.myapplication.service;

import nl.siegmann.epublib.domain.Book;

/**
 * Created by Vincent Galloy on 11/11/2016.
 *
 * @author Vincent Galloy
 */
public interface BookService {

    /**
     * Get a {@link Book} from path
     *
     * @param path the absolute path to the book
     * @return the corresponding book
     */
    Book getBook(String path);
}
