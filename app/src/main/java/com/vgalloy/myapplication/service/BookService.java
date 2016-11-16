package com.vgalloy.myapplication.service;

import nl.siegmann.epublib.domain.Book;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 11/11/2016.
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
