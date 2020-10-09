package com.epam.task.sixth.data.book;

import com.epam.task.sixth.data.DataException;
import com.epam.task.sixth.data.book.impl.sorter.BookSorterImpl;
import com.epam.task.sixth.data.book.impl.sorter.comparator.AuthorComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.GenreComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.IdComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.TitleComparator;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookTag;
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
