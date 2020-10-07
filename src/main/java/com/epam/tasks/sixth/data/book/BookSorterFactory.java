package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.sorters.*;
import com.epam.tasks.sixth.data.exceptions.UnknownBookSorterException;
import com.epam.tasks.sixth.model.BookTag;

public class BookSorterFactory {

    public BookSorter create(BookTag tag) throws UnknownBookSorterException {
        BookSorter toReturn;

        switch (tag) {
            case AUTHOR:
                toReturn = new AuthorBookSorter();
                break;
            case TITLE:
                toReturn = new TitleBookSorter();
                break;
            case GENRE:
                toReturn = new GenreBookSorter();
                break;
            case ID:
                toReturn = new IdBookSorter();
                break;
            default:
                throw new UnknownBookSorterException(
                        tag.name() + " sort doesn't exist");
        }

        return toReturn;
    }
}
