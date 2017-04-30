package com.vgalloy.myapplication.mapper.book;

import com.vgalloy.myapplication.model.SimpleBook;

import nl.siegmann.epublib.domain.Book;

/**
 * Created by Vincent Galloy on 30/04/2017.
 * This class is Thread-safe
 *
 * @author Vincent Galloy
 */
public interface BookMapper {

    /**
     * Map the complex {@link Book} object into a simple one
     *
     * @param book the book
     * @return the simple book
     */
    SimpleBook map(Book book);
}
