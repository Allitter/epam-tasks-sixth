package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.specification.*;
import com.epam.tasks.sixth.data.DataException;
import com.epam.tasks.sixth.model.BookTag;

public class BookSpecificationFactory {
    public BookSpecification create(BookTag tag, String value)
            throws DataException {

        BookSpecification toReturn;

        switch (tag) {
            case ID:
                toReturn = new IdBookSpecification(value);
                break;
            case GENRE:
                toReturn = new GenreBookSpecification(value);
                break;
            case TITLE:
                toReturn = new TitleBookSpecification(value);
                break;
            case AUTHOR:
                toReturn = new AuthorBookSpecification(value);
                break;
            default:
                throw new DataException(
                        tag.name() + " specification doesn't exist");
        }

        return toReturn;
    }
}
