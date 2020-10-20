package com.epam.task.sixth.data.book;

import com.epam.task.sixth.model.BookTag;
import com.epam.task.sixth.data.book.impl.specification.AuthorBookSpecification;
import com.epam.task.sixth.data.book.impl.specification.GenreBookSpecification;
import com.epam.task.sixth.data.book.impl.specification.IdBookSpecification;
import com.epam.task.sixth.data.book.impl.specification.TitleBookSpecification;

public class BookSpecificationFactory {
    public BookSpecification create(BookTag tag, String value) {
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
                throw new IllegalArgumentException(
                        tag.name() + " specification doesn't exist");
        }

        return toReturn;
    }
}
