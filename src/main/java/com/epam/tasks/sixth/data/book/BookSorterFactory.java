package com.epam.tasks.sixth.data.book;

import com.epam.tasks.sixth.data.book.sorter.*;
import com.epam.tasks.sixth.data.DataException;
import com.epam.tasks.sixth.data.book.sorter.comparator.AuthorComparator;
import com.epam.tasks.sixth.data.book.sorter.comparator.GenreComparator;
import com.epam.tasks.sixth.data.book.sorter.comparator.IdComparator;
import com.epam.tasks.sixth.data.book.sorter.comparator.TitleComparator;
import com.epam.tasks.sixth.model.Book;
import com.epam.tasks.sixth.model.BookTag;

import java.util.Comparator;

public class BookSorterFactory {

    public BookSorter create(BookTag tag) throws DataException {
        BookSorter toReturn;
        Comparator<Book> comparator;

        switch (tag) {
            case AUTHOR:
                comparator = new AuthorComparator();
                toReturn = new BookSorterImpl(comparator);
                break;
            case TITLE:
                comparator = new TitleComparator();
                toReturn = new BookSorterImpl(comparator);
                break;
            case GENRE:
                comparator = new GenreComparator();
                toReturn = new BookSorterImpl(comparator);
                break;
            case ID:
                comparator = new IdComparator();
                toReturn = new BookSorterImpl(comparator);
                break;
            default:
                throw new DataException(
                        tag.name() + " sort doesn't exist");
        }

        return toReturn;
    }
}
