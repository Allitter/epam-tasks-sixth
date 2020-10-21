package com.epam.task.sixth.data.book;

import com.epam.task.sixth.data.book.impl.sorter.comparator.AuthorComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.GenreComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.IdComparator;
import com.epam.task.sixth.data.book.impl.sorter.comparator.TitleComparator;
import com.epam.task.sixth.model.Book;
import com.epam.task.sixth.model.BookTag;
import java.util.Comparator;

public class BookComparatorFactory {

    public Comparator<Book> create(BookTag tag) {
        Comparator<Book>  toReturn;

        switch (tag) {
            case AUTHOR:
                toReturn = new AuthorComparator();
                break;
            case TITLE:
                toReturn = new TitleComparator();
                break;
            case GENRE:
                toReturn = new GenreComparator();
                break;
            case ID:
                toReturn = new IdComparator();
                break;
            default:
                throw new IllegalArgumentException(
                        tag.name() + " sort doesn't exist");
        }

        return toReturn;
    }
}
