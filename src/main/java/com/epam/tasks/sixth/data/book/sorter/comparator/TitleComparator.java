package com.epam.tasks.sixth.data.book.sorter.comparator;

import com.epam.tasks.sixth.model.Book;
import java.util.Comparator;

public class TitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        String title1 = o1.getTitle();
        String title2 = o2.getTitle();
        return title1.compareTo(title2);
    }
}
